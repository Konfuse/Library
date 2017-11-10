package com.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Book;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import com.utils.Scanner;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
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

		String location = request.getParameter("location");
		Book book = null;
		Object obj = Scanner.dealInfo();
		if (obj instanceof Book) {
			book = (Book)obj;
			book.setLocation(location);
			BookService bookServiceImpl = new BookServiceImpl();

			if (bookServiceImpl.addBook(book)) {
				request.setAttribute("state", 1);
				response.getWriter().write("Added successfully! Jumping after 5 seconds");
				response.setHeader("refresh", "5;url=" + request.getContextPath()
						+ "/index2.jsp");
			} else {
				response.getWriter().write("Add failed! Jumping after 5 seconds");
				response.setHeader("refresh", "5;url=" + request.getContextPath()
						+ "/addBook.jsp");
			}
		} else {
			response.getWriter().write("Wrong Scanning! Please scan again!");
			response.setHeader("refresh", "5;url=" + request.getContextPath()
					+ "/addBook.jsp");
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
