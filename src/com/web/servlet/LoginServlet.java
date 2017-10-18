package com.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private LoginServiceImpl loginService = new LoginServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String urn = request.getParameter("urn");
		String psw = request.getParameter("psw");
		String isLibrarian = request.getParameter("isLibrarian");
		boolean bool = loginService.check(urn, psw, isLibrarian);

		if (bool) {
			if (isLibrarian.equals("true")) {
				request.getSession().setAttribute("user_name", urn);
				request.getRequestDispatcher("/index2.html").forward(request, response);
			} else {
				request.getSession().setAttribute("user_name", urn);
				request.getRequestDispatcher("/search.jsp").forward(request, response);
			}

		} else {
			System.out.print("failed");
			response.sendRedirect("login.jsp?error=yes");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
