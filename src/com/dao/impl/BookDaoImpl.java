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
	public Boolean searchTheBook(String bookName) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		boolean state = false;

		String sql = "select book_name from book where book_name = '" + bookName + "'";

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
			String sql = "insert into book values ('" + book.getBook_name() + "','" + book.getAuthor() + "','"
					+ book.getPublishing() + "','" + book.getNum() + "','" + book.getLocation() + "')";
			stmt = conn.createStatement();
			state = (stmt.executeUpdate(sql) != 0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, stmt, pstmt, conn);
		}

		return state;
	}

	// 借书
	public boolean borrowBook(String bookName) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		boolean state = false;

		try {
			conn = DBUtils.getConnection();
			String sql0 = "select num from book where book_name = '" + bookName + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql0);
			rs.next();
			if (rs.getInt(1) <= 0) {
				return false;
			}
			String sql = "update book set num=num-1 where book_name = '" + bookName + "'";
			state = (stmt.executeUpdate(sql) != 0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, stmt, pstmt, conn);
		}

		return state;
	}

	// 还书
	public boolean returnBook(String bookName, int count) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean state = false;

		try {
			conn = DBUtils.getConnection();
			String sql = "update book set num=num+" + count + " where book_name = '" + bookName + "'";
			stmt = conn.createStatement();
			state = (stmt.executeUpdate(sql) != 0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, stmt, pstmt, conn);
		}

		return state;
	}
}
