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

@WebServlet("/ContactUsControllerServlet")
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

        System.out.println("here");
//        String command = req.getParameter("command");
//
//        if(command == null) command = "list";
//        switch (command){
//            case "add":
//                addContactDetailsToDatabase(req,resp);
//                break;
//            default:
//                listContactDetails(req,resp);
//
//        }
        contactDBUtil.moveContactsFromActiveToArchived(26);
    }

    private void addContactDetailsToDatabase(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        // Step-1 Get the data entered in form
        String fullName = req.getParameter("full_name");
        String email = req.getParameter("email");
        String message = req.getParameter("message");

        // Step-2 Make a contact from form data and forward add request to ContactDBUtil
        Contact contact = new Contact(fullName, email, message);
        contactDBUtil.addContactToDatabase(contact);

        resp.sendRedirect("/ContactUsSection/contact-us.jsp");

        // TODO: May need to redirect to home page as per use case....
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
