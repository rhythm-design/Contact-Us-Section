package com.rhythm.contactussection;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContactDBUtil {
    private DataSource dataSource;
    
    ContactDBUtil(DataSource dataSource){
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

    }

    public void moveContactsFromActiveToArchived(Contact contact){
        // contact id
    }
}
