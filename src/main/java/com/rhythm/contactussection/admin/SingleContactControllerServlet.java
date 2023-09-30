package com.rhythm.contactussection.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin/contactus/singlecontact")
public class SingleContactControllerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("full_name");
        String email = req.getParameter("email");
        String message = req.getParameter("message");
        String contactId = req.getParameter("contactid");
        req.setAttribute("full_name",fullName);
        req.setAttribute("email",email);
        req.setAttribute("message",message);
        req.setAttribute("contactid",contactId);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view-single-message.jsp");
        requestDispatcher.forward(req,resp);
        req.removeAttribute("full_name");

    }
}
