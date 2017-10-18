package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dao.BorrowInfor;
import com.utils.DBUtils;

public class BorrowInforImpl implements BorrowInfor {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public void add(String book_name, String reader_name, String time) {
		String sql = "insert into borrow_infor values(?,?,?)";
		try {
			try {
				conn = DBUtils.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book_name);
			pstmt.setString(2, reader_name);
			pstmt.setString(3, time);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, stmt, pstmt, conn);
		}
	}

	@Override
	public void delete(String book_name, String reader_name, String time) {
		// TODO Auto-generated method stub

	}

}
