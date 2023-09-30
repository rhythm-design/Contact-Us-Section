package com.rhythm.contactussection.admin;

import com.rhythm.contactussection.Contact;
import com.rhythm.contactussection.ContactDBUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/admin/contactus/requests")
public class AdminDashboardServlet extends HttpServlet {

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
        HttpSession session = req.getSession(false);
        // session != null && session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")
        if (session != null && session.getAttribute("adminLoggedIn") != null && (boolean) session.getAttribute("adminLoggedIn")) {
            listContactDetails(req,resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/admin/login");
        }
    }

    private void listContactDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Step-1 Get data from ContactDBUtil
        List<Contact> activeContactsList = contactDBUtil.listContactDetails("activecontacts");

        List<Contact> archievedContactsList = contactDBUtil.listContactDetails("archievedcontacts");

        // Step-2 Set attribute to the contactList to make it accessible across session
        req.setAttribute("ACTIVE_CONTACT_LIST", activeContactsList);
        req.setAttribute("ARCHIEVED_CONTACT_LIST", archievedContactsList);

        // Step-3 Send the data to JSP page for awesome view
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin-dashboard.jsp");
        requestDispatcher.forward(req,resp);
    }
}
