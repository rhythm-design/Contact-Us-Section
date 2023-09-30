package com.rhythm.contactussection;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContactDBUtil {
    private DataSource dataSource;
    
    public ContactDBUtil(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<Contact> listContactDetails(String table){
        List<Contact> contacts = new ArrayList<>();
        String sqlQuery = "SELECT * FROM " + table;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()){
                long id = resultSet.getLong("id");
                String fullName = resultSet.getString("full_name");
                String email = resultSet.getString("email");
                String message = resultSet.getString("message");
                contacts.add(new Contact(fullName, email, message, id));
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

        return contacts;
    }

    public void addContactToDatabase(Contact contact){
        String sqlQuery = "INSERT INTO activecontacts " +
                "(full_name, email, message) " +
                "VALUES(?,?,?)";
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sqlQuery);

            statement.setString(1, contact.getFullName());
            statement.setString(2, contact.getEmail());
            statement.setString(3, contact.getMessage());
            statement.execute();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                connection.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void moveContactFromTableToTableById(String fromTable, String toTable, long id){
        // contact id
        String moveSqlQuery = "INSERT INTO " + toTable + " (full_name, email, message)" +
                " SELECT full_name, email, message FROM " +
                fromTable+
                " WHERE id=" + id + ";";

        String deleteSqlQuery = "DELETE FROM " + fromTable +
                " WHERE id=" + id + ";";

        Connection connection = null;
        Statement statement = null;
        try{
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            statement.execute(moveSqlQuery);
            statement.execute(deleteSqlQuery);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                connection.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}
