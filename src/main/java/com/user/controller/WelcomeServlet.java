package com.user.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/welcome")
public class WelcomeServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect("WEB-INF/Welcome.jsp");
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/WEB-INF/Welcome.jsp" );
        dispatcher.forward( req, resp );
    }
}
