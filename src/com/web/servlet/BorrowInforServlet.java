package com.web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.BookService;
import com.service.impl.BookServiceImpl;
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

		String reader_name = request.getParameter("reader_name");
		String book_id = request.getParameter("book_id");

		BookService bd = new BookServiceImpl();

		String name = (String) request.getSession().getAttribute("ad_name");
		if (name != null) {
			try {
				if (bd.borrow(book_id, reader_name) == false) {
					request.setAttribute("state", 0);
					response.getWriter().write("Borrow failed!");
					response.setHeader("refresh", "5;url=" + request.getContextPath() + "/index2.jsp");
					return;
				} else {
					Date now = new Date();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					BorrowServiceImpl borrowServiceImpl = new BorrowServiceImpl();
					if (borrowServiceImpl.borrowInfor(book_id, reader_name, dateFormat.format(now))) {
						request.setAttribute("state", 1);
						response.getWriter().write("Borrow successfully! Jumping after 5 seconds");
						response.setHeader("refresh", "5;url=" + request.getContextPath() + "/index2.jsp");
						return;
					} else {
						request.setAttribute("state", 0);
						response.getWriter().write("Borrow failed!");
						response.setHeader("refresh", "5;url=" + request.getContextPath() + "/index2.jsp");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			response.getWriter().write("Add failed! please log in first");
			response.setHeader("refresh", "5;url=" + request.getContextPath()
					+ "/login.jsp");
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
