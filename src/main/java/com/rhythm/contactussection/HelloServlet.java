package com.rhythm.contactussection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {

    private DataSource dataSource;

    private InitialContext initialContext;

    @Override
    public void init() throws ServletException {
        super.init();
        try{
            initialContext = new InitialContext();
            dataSource = (DataSource) initialContext.lookup("java:/comp/env/jdbc/customer_queries");
        }catch(NamingException namingException){
            System.out.printf("Naming Exception thrown at %s",this);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM students");

            while (resultSet.next()){
                out.println("<h1>" + resultSet.getString(1) + "</h2>");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                assert resultSet != null;
                resultSet.close();
                statement.close();
                connection.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
