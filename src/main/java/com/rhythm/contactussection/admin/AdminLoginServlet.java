package com.rhythm.contactussection.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("login-action");
        if(command != null){
            ServletContext context = getServletContext();
            String contextUsername = context.getInitParameter("username");
            String contextPassword = context.getInitParameter("password");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            if(contextUsername.equals(username) && contextPassword.equals(password)){
                HttpSession session = req.getSession();
                session.setAttribute("adminLoggedIn",true);
                resp.sendRedirect("contactus/requests");
            }else {
                req.setAttribute("errorMessage", "Invalid credentials. Please try again.");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login-page.jsp");
                requestDispatcher.forward(req, resp);
            }
        }else{
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login-page.jsp");
            requestDispatcher.forward(req,resp);
        }
    }
}
