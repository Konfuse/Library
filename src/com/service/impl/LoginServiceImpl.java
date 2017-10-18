package com.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;

import com.dao.UserInformationDao;
import com.dao.impl.UserInformationDaoImpl;
import com.service.LoginService;
import com.utils.DBUtils;

public class LoginServiceImpl implements LoginService {
	private UserInformationDao userInformationDao = new UserInformationDaoImpl();

	public boolean check(String urn, String psw, String isLibrarian) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			conn.setAutoCommit(false);
			ResultSet resultSet = null;
			if (isLibrarian.equals("true")) {
				resultSet = userInformationDao.getLibrarian(conn, urn, psw);
			} else {
				resultSet = userInformationDao.get(conn, urn, psw);
			}
			while (resultSet.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;

	}
}
