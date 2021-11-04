package com.cydeo.day2;

import java.sql.*;

public class PracticeConnection {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@54.90.169.134:1521:XE";
        String username = "hr";
        String password = "hr";

        // STEP 1   GET CONNECTION OBJECT
        Connection conn = DriverManager.getConnection(url, username, password);

        // STEP 2 CREATE A STATEMENT OBJECT
        Statement stmnt = conn.createStatement();

        // STEP 3    GET RESULT_SET BY RUNNING EXECUTE-QUERY METHOD OF STATEMENT OBJECT
        ResultSet rs = stmnt.executeQuery("select * from regions");

        // STEP 4    NAVIGATE THROUGH THE RESULTsET OBJECT TO GET CELL VALUE
        rs.next();// move the cursor from before first location to the first row

        // STEP5 NAVIGATE THROUGH THE RESULT_SET getX METHODS LIKE get String

        // read regionID and Region_name column and print it out
        System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));

        System.out.println("rs.getString(\"REGION_NAME\") = " + rs.getString("REGION_NAME"));

        // move to the next row ...
        rs.next();
        System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));
        System.out.println("rs.getString(\"REGION_NAME\") = " + rs.getString("REGION_NAME"));

        // move to the next row ...
        rs.next();
        System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));
        System.out.println("rs.getString(\"REGION_NAME\") = " + rs.getString("REGION_NAME"));
        // move to the next row ...
        rs.next();
        System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));
        System.out.println("rs.getString(\"REGION_NAME\") = " + rs.getString("REGION_NAME"));
        // move to the 5 row ... which does not exist
        rs.next();
        System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));
        System.out.println("rs.getString(\"REGION_NAME\") = " + rs.getString("REGION_NAME"));


        System.out.println("THE END !!!");


    }


}
