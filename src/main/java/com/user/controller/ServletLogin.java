package com.user.controller;

import com.user.dao.UserDao;
import com.user.model.User;
import com.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class ServletLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao bd = new UserDao();
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String remember=req.getParameter("remember");

        HttpSession session = req.getSession();
        UserService service = new UserService();


        if (service.check(username,password)) {
            session = req.getSession();
            session.setAttribute("user",username);
            req.setAttribute("user",username);
            if ("yes".equals(remember)){
                Cookie cookie = new Cookie("user",username);
                cookie.setMaxAge(30*60*60*24);
                resp.addCookie(cookie);
            }else {

                Cookie cookie = new Cookie("user",null);
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }

            resp.sendRedirect("welcome");
        }else {

            session.setAttribute("error","Invalid username or password ");
            resp.sendRedirect("login");

        }

    }
}
