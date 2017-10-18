package com.web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.impl.BookDaoImpl;
import com.service.impl.BorrowServiceImpl;

/**
 * Servlet implementation class BorrowInforServlet
 */
@WebServlet("/BorrowInforServlet")
public class BorrowInforServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String book_name = request.getParameter("book_name");
		int num = Integer.parseInt(request.getParameter("num"));
		String reader_name = request.getParameter("user_name");
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		BorrowServiceImpl borrowServiceImpl = new BorrowServiceImpl();
		borrowServiceImpl.addInfor(book_name, reader_name, dateFormat.format(now));

		if (num <= 0) {
			request.setAttribute("state", 0);
			response.getWriter().write("Borrow failed!");
			response.setHeader("refresh", "5;url=" + request.getContextPath()
					+ "/search.jsp");
			return;
		}

		BookDaoImpl bd = new BookDaoImpl();

		try {
			if (bd.borrowBook(book_name) == false) {
				request.setAttribute("state", 0);
				response.getWriter().write("Borrow failed!");
				response.setHeader("refresh", "5;url=" + request.getContextPath()
						+ "/search.jsp");
				return;
			} else {
				request.setAttribute("state", 1);
				response.getWriter().write("Borrow successfully! Jumping after 5 seconds");
				response.setHeader("refresh", "5;url=" + request.getContextPath()
						+ "/search.jsp");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
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
