package com.cydeo.day1;

import java.sql.*;

public class TestOracleConnection {

    public static void main(String[] args) {


    // make initial connection to Oracle database we have

    // step1 add oracle driver dependency in pom.xml


        // conection information
        // connection string (JDBC URL): jdbc:oracle:thin@54.90.169.134:1521:XE
        //54.90.169.134
        // username/ password :   hr/hr

        String url = "jdbc:oracle:thin:@54.90.169.134:1521:XE";
        String username = "hr";
        String password = "hr";


        // 1. create connection use DriverManager class and save the connection
        try {
            // DriverManager class getConnection method is used to create connection
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("CONNECTION WAS SUCCESSFUL");

            // Create statement Object form connection so we can eventually run query
            Statement stmnt = conn.createStatement();
            // ResultSet use cursor or pointer to navigate through the rows
            // by default the pointer is at a location known as BeforeFirst location
            // meaning right before first row of data
            // in order to move to the first row , we need to call next() method
            // everytime you call next method you it will jump t next row
            // you can use getString( column name ) to get the cell value
            ResultSet rs = stmnt.executeQuery("select * from regions");
            // Result set use the cursor or pointer to navigatr through the rows
            // by default the pointer is at a location known as Beforefirst location


            rs.next();
            // now we are at first row we can use getString() method to get Region_name
            System.out.println(rs.getString("REGION_NAME"));

            rs.next();
            System.out.println(rs.getString("REGION_NAME"));






        } catch (SQLException e) {

            System.out.println("ERROR WHILE CONNECTING" + e.getMessage());
            e.printStackTrace();
        }



    }

}
