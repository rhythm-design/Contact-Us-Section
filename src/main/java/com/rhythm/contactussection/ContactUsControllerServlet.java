package com.rhythm.contactussection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/contactus")
public class ContactUsControllerServlet extends HttpServlet {

    private ContactDBUtil contactDBUtil;

    private DataSource dataSource;

    private InitialContext initialContext;

    @Override
    public void init() throws ServletException {
        super.init();
        try{
            initialContext = new InitialContext();
            dataSource = (DataSource) initialContext.lookup("java:/comp/env/jdbc/customer_queries");
            contactDBUtil = new ContactDBUtil(dataSource);
        }catch(NamingException namingException){
            System.out.printf("Naming Exception thrown at %s",this);
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("command");
        if(command != null){
            addContactDetailsToDatabase(req,resp);
        }else{
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/contact-us.jsp");
            requestDispatcher.forward(req,resp);
        }
        resp.sendRedirect("contactus");
    }

    private void addContactDetailsToDatabase(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


        // Step-1 Get the data entered in form
        String fullName = req.getParameter("full_name");
        String email = req.getParameter("email");
        String message = req.getParameter("message");

        // Step-2 Make a contact from form data and forward add request to ContactDBUtil
        Contact contact = new Contact(fullName, email, message);
        contactDBUtil.addContactToDatabase(contact);

        // Step-3 Send request to process from jsp page
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/contact-us.jsp");
        requestDispatcher.forward(req,resp);

    }


}
