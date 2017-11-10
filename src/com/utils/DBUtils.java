package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBUtils {

	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;

	static {
		ResourceBundle rb = ResourceBundle.getBundle("dbinfo");
		driverClass = rb.getString("driverClass");
		url = rb.getString("url");
		username = rb.getString("username");
		password = rb.getString("password");
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 得到连接的方法
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(url, username, password);
	}

	// 关闭资源的方法
	public static void closeAll(ResultSet rs, Statement stmt, PreparedStatement pstmt, Connection conn) {
		try {
            if (rs != null) {
                    rs.close();
            }

            if (stmt != null) {
                    stmt.close();
            }

            if (pstmt != null) {
                    pstmt.close();
            }

            if (conn != null) {
                    conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
