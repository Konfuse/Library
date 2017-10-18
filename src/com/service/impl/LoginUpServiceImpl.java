package com.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.dao.UserInformationDao;
import com.dao.impl.UserInformationDaoImpl;
import com.service.LoginUpService;
import com.utils.DBUtils;

public class LoginUpServiceImpl implements LoginUpService {
	private UserInformationDao userInformationDao = new UserInformationDaoImpl();

	public boolean update(String urn, String psw) {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			int code = userInformationDao.loginUp(conn, urn, psw);
			if (code == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
}
