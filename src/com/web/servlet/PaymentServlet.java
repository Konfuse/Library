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
import com.service.BorrowService;
import com.service.impl.BookServiceImpl;
import com.service.impl.BorrowServiceImpl;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
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

		double payment = Double.parseDouble(request.getParameter("payment"));
		String book_id = (String) request.getSession().getAttribute("book_id");
		double money = (double) request.getSession().getAttribute("money");
		String borrow_time = (String) request.getSession().getAttribute("borrow_time");

		String name = (String) request.getSession().getAttribute("ad_name");
		if (name != null) {

			if (payment == money) {
				BorrowService bs = new BorrowServiceImpl();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date now = new Date();
				String now_ = sdf.format(now);
				if (bs.returnInfor(book_id,borrow_time,now_, payment)) {
					BookService bd = new BookServiceImpl();
					if (bd.returnBook(book_id)) {
						response.getWriter().write("Return successfully! Jumping after 5 seconds");

					} else {
						response.getWriter().write("Return failed!");
					}
				} else {
					response.getWriter().write("Return failed!");
				}
			} else {
				response.getWriter().write("Please enter the correct amount of money! Jumping after 5 seconds");
				response.setHeader("refresh", "5;url=" + request.getContextPath() + "/payment.jsp");
			}
			response.setHeader("refresh", "5;url=" + request.getContextPath() + "/index2.jsp");
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
