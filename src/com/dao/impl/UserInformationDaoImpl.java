package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.UserInformationDao;
import com.utils.DBUtils;

public class UserInformationDaoImpl implements UserInformationDao {

	@Override
	public ResultSet get(Connection conn, String urn, String psw) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select * from reader where reader_name=? and reader_psw=?");
		ps.setString(1, urn);
		ps.setString(2, psw);
		return ps.executeQuery();
	}

	public ResultSet getLibrarian(Connection conn, String urn, String psw) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select * from administrator where ad_name=? and ad_psw=?");
		ps.setString(1, urn);
		ps.setString(2, psw);
		return ps.executeQuery();
	}

	@Override
	public int loginUp(Connection conn, String urn, String psw) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("insert into reader values(?,?);");
		ps.setString(1, urn);
		ps.setString(2, psw);
		int code = ps.executeUpdate();
		return code;
	}

	@Override
	public String searchReader(String urn) {
		Connection conn = null;
		ResultSet rs = null;
		String pwd = null;

		try {
			conn = DBUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement("select reader_psw from reader where reader_name=?");
			ps.setString(1, urn);
			rs = ps.executeQuery();
			if (rs.next()) {
				pwd = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pwd;
	}

}
