package com.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Book;
import com.service.impl.BookServiceImpl;

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

		String book_name = request.getParameter("book_name");
		String author = request.getParameter("author");
		String publishing = request.getParameter("publishing");
		int num = Integer.parseInt(request.getParameter("num"));
		String location = request.getParameter("location");
		Book book = new Book();
		book.setBook_name(book_name);
		book.setAuthor(author);
		book.setPublishing(publishing);
		book.setNum(num);
		book.setLocation(location);

		String name = (String) request.getSession().getAttribute("user_name");
		if (name != null) {
			BookServiceImpl bookServiceImpl = new BookServiceImpl();
			if (bookServiceImpl.addBook(book)) {
				request.setAttribute("state", 1);
				response.getWriter().write("Added successfully! Jumping after 5 seconds");
				response.setHeader("refresh", "5;url=" + request.getContextPath()
						+ "/index2.html");
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
