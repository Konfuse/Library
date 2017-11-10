package com.web.servlet;

import com.dao.UserInformationDao;
import com.dao.impl.UserInformationDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ReaderQueryServlet")
public class ReaderQueryServlet extends HttpServlet {
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
        String readerName = request.getParameter("readerInfo");
        String passWord = null;

        UserInformationDao ui = new UserInformationDaoImpl();

        try {
            passWord = ui.searchReader(readerName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (passWord != null) {
            request.setAttribute("readerName", readerName);
            request.setAttribute("passWord", passWord);
            request.getRequestDispatcher("/readerQuery.jsp").forward(request, response);
        }else {
            response.getWriter().write("Did not successfully match any record ! 5 seconds to jump to the search page");
            response.setHeader("refresh", "5;url=" + request.getContextPath()+ "/query.html");
        }
    }
}
