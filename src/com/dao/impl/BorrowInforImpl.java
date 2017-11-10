package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.dao.BorrowInfor;
import com.utils.DBUtils;

public class BorrowInforImpl implements BorrowInfor {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public boolean borrowInfor(String book_id, String reader_name, String time) {
		String sql = "insert into borrow_infor values(?,?,?,?)";
		try {
			try {
				conn = DBUtils.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book_id);
			pstmt.setString(2, reader_name);
			pstmt.setString(3, time);
			pstmt.setInt(4, 1);
			return (pstmt.executeUpdate() != 0);
		} catch (SQLException e) {
			return false;
		} finally {
			DBUtils.closeAll(rs, stmt, pstmt, conn);
		}
	}

	@Override
	public boolean returnInfor(String book_id,String borrow_time,String return_time, double payment) {
		String sql0 = "select reader_name from borrow_infor where book_id = '" + book_id + "' and borrow_flag=1";
		String sql = "insert into return_infor values(?,?,?,?,?)";
		try {
			try {
				conn = DBUtils.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql0);
			rs.next();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book_id);
			pstmt.setString(2, rs.getString(1));
			pstmt.setString(3, borrow_time);
			pstmt.setString(4, return_time);
			pstmt.setDouble(5,payment);
			return (pstmt.executeUpdate() != 0);
		} catch (SQLException e) {
			return false;
		} finally {
			DBUtils.closeAll(rs, stmt, pstmt, conn);
		}
	}

	@Override
	public Date searchInfor(String book_id) {
		String sql0 = "select borrow_time from borrow_infor where book_id = '" + book_id + "' and borrow_flag=1";
		try {
			conn = DBUtils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql0);
			if (rs.next()) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date date = dateFormat.parse(rs.getString(1));
				return date;
			}else {
			}
		} catch (Exception e) {
			return null;
		} finally {
			DBUtils.closeAll(rs, stmt, pstmt, conn);
		}
		return null;
	}

}
