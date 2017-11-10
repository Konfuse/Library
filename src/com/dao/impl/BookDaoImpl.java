package com.dao.impl;

import com.dao.BookDao;
import com.domain.Book;
import com.utils.DBUtils;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class BookDaoImpl implements BookDao {

	@SuppressWarnings("null")
	@Override
	// 模糊搜书
	public List<Book> searchBook(String input) throws Exception {
		List<Book> bookList = null;
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		if (!input.equals("")) {
			String sql = "select * from book where book_name like ? or author like ?;";
			try {
				conn = DBUtils.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + input + "%");
				pstmt.setString(2, "%" + input + "%");
				rs = pstmt.executeQuery();
				if (rs.next()) {
					rs.previous();
					BeanListHandler<Book> bh = new BeanListHandler<Book>(Book.class);
					bookList = bh.handle(rs);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtils.closeAll(rs, stmt, pstmt, conn);
			}
		}

		return bookList;
	}

	// 精确搜书
	public Boolean searchTheBook(String bookName, String author) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		boolean state = false;

		String sql = "select book_name from book where book_name = '" + bookName + "' and author = '" + author + "'";

		try {
			conn = DBUtils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				state = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, stmt, pstmt, conn);
		}

		return state;
	}

	public boolean addBook(Book book) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean state = false;

		try {
			conn = DBUtils.getConnection();
			stmt = conn.createStatement();
			int borrow_flag = 0;
			String sql0 = "insert into book values ('" + book.getBook_id() + "','" + book.getBook_name() + "','" + book.getAuthor()
					+ "','" + book.getPublishing() + "','" + book.getPublishing_time() + "','" + book.getIsbn() + "')";
			state = (stmt.executeUpdate(sql0) != 0);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, stmt, pstmt, conn);
		}

		return state;
	}

	// 借书
	public boolean borrowBook(String book_id, String reader_name) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		boolean state = false;

		try {
			conn = DBUtils.getConnection();
			String sql = "select reader_name from reader where reader_name = '" + reader_name + "'";// 先检查读者是否存在
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (!rs.next()) {
				return false;
			} else {
				rs.close();
				String sql0 = "select book_name,author,borrow_flag from book_id where book_id = '" + book_id + "'";
				rs = stmt.executeQuery(sql0);
				if (!rs.next()) {
					return false;
				} else {
					String bookName = rs.getString(1);
					String author = rs.getString(2);
					int borrow_flag = rs.getInt(3);
					if (borrow_flag == 0) {// 检查书是否已被借
						String sql1 = "select num from book where book_name = '" + bookName + "' and author = '"
								+ author + "'";
						rs.close();
						rs = stmt.executeQuery(sql1);
						if (rs.next()) {
							if (rs.getInt(1) <= 0) {
								state = false;
							} else {
								String sql2 = "update book set num=num-1 where book_name = '" + bookName
										+ "'and author = '" + author + "'";
								String sql3 = "update book_id set borrow_flag=1 where book_id = '" + book_id + "'";
								stmt.executeUpdate(sql2);
								state = (stmt.executeUpdate(sql3) != 0);
							}
						} else {
							state = false;
						}

					} else {
						state = false;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, stmt, pstmt, conn);
		}

		return state;
	}

	// 还书
	public boolean returnBook(String book_id) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean state = false;

		try {
			conn = DBUtils.getConnection();
			String sql1 = "select book_name,author,borrow_flag from book_id where book_id = '" + book_id + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			if (rs.next()) {
				if (rs.getInt(3) == 1) {
					String bookName = rs.getString(1);
					String author = rs.getString(2);
					String sql2 = "update book set num=num+1 where book_name = '" + bookName + "'and author = '"
							+ author + "'";
					String sql3 = "update book_id set borrow_flag=0 where book_id = '" + book_id + "'";
					String sql4 = "update borrow_infor set borrow_flag=0 where book_id = '" + book_id + "' and borrow_flag=1";
					stmt.executeUpdate(sql2);
					stmt.executeUpdate(sql3);
					state = (stmt.executeUpdate(sql4) != 0);
				}else {
					return state;
				}
			} else {
				return state;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, stmt, pstmt, conn);
		}

		return state;
	}

	public boolean deleteBook(String id) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean state = false;

		try {
			conn = DBUtils.getConnection();
			stmt = conn.createStatement();

			String sql = "select book_name from book where book_id = '" + id + "' and borrow_flag=0";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (!rs.next()){
				return false;
			}

			sql = "delete from book where book_id= '" + id + "'";
			state = (stmt.executeUpdate(sql) != 0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, stmt, pstmt, conn);
		}
		return state;
	}

	@Override
	public boolean changeLocation(Book book) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean state = false;

		try {
			conn = DBUtils.getConnection();
			stmt = conn.createStatement();

			String sql = "update book set location='" + book.getLocation() + "'where book_id = '" + book.getBook_id() + "'and author = '" + book.getAuthor() + "'";
			state = (stmt.executeUpdate(sql) != 0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, stmt, pstmt, conn);
		}
		return state;
	}
}
