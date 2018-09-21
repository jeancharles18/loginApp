package com.user.controller;

import com.user.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "FilterLogin",
       urlPatterns = {"/welcome"})
public class FilterLogin implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);
//        User user = session == null ? null : (session.getAttribute("user") == null ? null : (User) session.getAttribute("user"));
        String username = (String) session.getAttribute("user");
        if (username!=null && !username.isEmpty()){
                     chain.doFilter(req, resp);
        }
        else {
            session.setAttribute("error","Invalid username or password ");
            response.sendRedirect("login");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
