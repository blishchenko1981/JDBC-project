package com.cydeo.day2;

import java.sql.*;

public class FlexibleNavigation {

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
            ResultSet rs = stmnt.executeQuery("select * from employees");

            // navigations methods for moving cursors
            /**
             * next()        --move to next row and return true false according to if we have valid row
             * previous()    -move to previous row and return true false according to if we have valid row
             * first()       - move to first row from anywhere
             * last()        - move to last row from anywhere
             * beforeFirst() - move to before first location from anywhere
             * afterLast()   - move to after last location from anywhere
             * absolute(8)   - move to any row by using row number
             */

            // getting row number of current row: rs.getRow();

            System.out.println("rs.getRow() = " + rs.getRow());

            rs.next();
            System.out.println("rs.getRow() = " + rs.getRow());
            System.out.println("rs.getString(\"EMPLOYEE_ID\") = " + rs.getString("EMPLOYEE_ID"));

            rs.last();
            System.out.println("rs.getRow() = " + rs.getRow());
            System.out.println("rs.getString(\"EMPLOYEE_ID\") = " + rs.getString("EMPLOYEE_ID"));

            rs.previous();
            System.out.println("rs.getRow() = " + rs.getRow());
            System.out.println("rs.getString(\"EMPLOYEE_ID\") = " + rs.getString("EMPLOYEE_ID"));

            rs.absolute(100);
            System.out.println("rs.getRow() = " + rs.getRow());
            System.out.println("rs.getString(\"EMPLOYEE_ID\") = " + rs.getString("EMPLOYEE_ID"));

            rs.first();
            System.out.println("rs.getRow() = " + rs.getRow());
            System.out.println("rs.getString(\"EMPLOYEE_ID\") = " + rs.getString("EMPLOYEE_ID"));

            rs.afterLast();
            rs.previous();
            System.out.println("rs.getRow() = " + rs.getRow());
            System.out.println("rs.getString(\"EMPLOYEE_ID\") = " + rs.getString("EMPLOYEE_ID"));

            rs.beforeFirst();


            // how to get count of all rows
            rs.last();
            System.out.println("TOTAL ROW COUNT IS - " + rs.getRow());

        }
}
