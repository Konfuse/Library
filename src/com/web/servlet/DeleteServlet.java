package com.web.servlet;

import com.domain.Book;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import com.utils.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().append("Served at: ").append(request.getContextPath());

        Book book = null;
        Object obj = Scanner.dealInfo();
        if (obj instanceof Book) {
            book = (Book) obj;
            BookService bs = new BookServiceImpl();

            if(bs.deleteBook(book.getBook_id())) {
                response.getWriter().write("Delete Successfully! Jumping after 5 seconds!");
                response.setHeader("refresh", "5;url=" + request.getContextPath() + "/index2.jsp");
            } else {
                response.getWriter().write("Delete Failed! Jumping after 5 seconds!");
                response.setHeader("refresh", "5;url=" + request.getContextPath() + "/delete.jsp");
            }
        } else {
            response.getWriter().write("Wrong Scanning! Please scan again!");
            response.setHeader("refresh", "5;url=" + request.getContextPath() + "/delete.jsp");
        }
    }
}
