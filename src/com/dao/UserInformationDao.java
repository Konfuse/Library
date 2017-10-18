package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserInformationDao {

	ResultSet get(Connection conn, String id, String psw) throws SQLException;
	ResultSet getLibrarian(Connection conn, String id, String psw) throws SQLException;
	int loginUp(Connection conn, String urn, String psw) throws SQLException;
}
