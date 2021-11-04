package com.cydeo.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class TestMySQL_Connection {

    public static void main(String[] args) {

        // connection string or url for library app library2 environment
        String url = "jdbc:mysql://54.157.236.232:3306/library2" ;
        String username = "library2_client" ;
        String password = "6s2LQQTjBcGFfDhY" ;

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("LIBRARY DB CONNECTION SUCCESSFUL ");

        } catch (SQLException e) {

            System.out.println("ERROR WHILE CONNECTION " + e.getMessage());
           // e.printStackTrace();
        }

    }



}
