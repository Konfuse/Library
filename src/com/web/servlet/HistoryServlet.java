package com.web.servlet;

import com.domain.BorrowHistory;
import com.service.ViewHistory;
import com.service.impl.ViewHistoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/HistoryServlet")
public class HistoryServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ViewHistory viewHistory = new ViewHistoryImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().append("Served at: ").append(request.getContextPath());
        String reader_name = (String) request.getSession().getAttribute("reader_name");
        List<BorrowHistory> borrowHistories = null;
        try{
            borrowHistories = viewHistory.view(reader_name);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (borrowHistories != null){
            request.setAttribute("borrowHistoryList",borrowHistories);
            request.getRequestDispatcher("/borrowHistory.jsp").forward(request, response);
        }
        else{
            response.getWriter().write("You didn't have borrow history ! 5 seconds to jump to the search page");
            response.setHeader("refresh", "5;url=" + request.getContextPath()+ "/search.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
