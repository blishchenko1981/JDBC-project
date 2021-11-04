package com.cydeo.day2;

import java.sql.*;

public class LoopingAllRow {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@54.90.169.134:1521:XE";
        String username = "hr";
        String password = "hr";

        // STEP 1   GET CONNECTION OBJECT
        Connection conn = DriverManager.getConnection(url, username, password);

        // STEP 2 CREATE A STATEMENT OBJECT
        // AND WE WANT TO BE ABLE TO MOVE CURSOR EVERYWHERE



        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        // STEP 3    GET RESULT_SET BY RUNNING EXECUTE-QUERY METHOD OF STATEMENT OBJECT
        ResultSet rs = stmnt.executeQuery("select * from regions");


        // STEP 4    loop through all rows and print items
        //        // rs.next() move the cursor to next row ,
        //        // return true if next row is valid , false if not,
        //        // so we can use it in while condition

        while (rs.next()) {
            System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));
            System.out.println("rs.getString(\"REGION_NAME\") = " + rs.getString("REGION_NAME"));
        }

        //    rs.previous();
        //     System.out.println("rs.getString(\"REGION_ID\") = " + rs.getString("REGION_ID"));
        // RESULT CAN NOT GO AFTER IT MOVED TO AFTER ALL , IT WILL THROW EXCEPTION







    }
}
