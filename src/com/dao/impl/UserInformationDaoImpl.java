package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.UserInformationDao;

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

}
