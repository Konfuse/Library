package com.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Book;
import com.service.BookService;
import com.service.impl.BookServiceImpl;

/**
 * Servlet implementation class searchServlet
 */
@WebServlet("/searchServlet")
public class SearchServlet extends HttpServlet {
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
		// 获取表单数据
		String input = "";
		try {
			input = request.getParameter("input");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 处理业务逻辑
		BookService bs = new BookServiceImpl();
		List<Book> bl = null;
		try {
			bl = bs.search(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 分发转向
		if (bl != null) {
			request.setAttribute("bookList", bl);
			request.getRequestDispatcher("/list.jsp").forward(request, response);
		}else {
			response.getWriter().write("Did not successfully match any record ! 5 seconds to jump to the search page");
			response.setHeader("refresh", "5;url=" + request.getContextPath()+ "/index.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
