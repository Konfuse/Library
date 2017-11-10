package com.web.servlet;

import com.domain.Book;
import com.service.BookService;
import com.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/BookQueryServlet")
public class BookQueryServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().append("Served at: ").append(request.getContextPath());
        String bookInfo = request.getParameter("bookInfo");

        BookService bs = new BookServiceImpl();
        List<Book> bookList = null;
        try {
            bookList = bs.search(bookInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (bookList != null) {
            request.setAttribute("bookList", bookList);
            request.getRequestDispatcher("/bookQuery.jsp").forward(request, response);
        }else {
            response.getWriter().write("Did not successfully match any record ! 5 seconds to jump to the search page");
            response.setHeader("refresh", "5;url=" + request.getContextPath()+ "/query.html");
        }
    }
}
