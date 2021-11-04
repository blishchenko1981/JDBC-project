package com.cydeo.day2;

import java.sql.*;

public class GettingColumnInformation {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@54.90.169.134:1521:XE";
        String username = "hr";
        String password = "hr";

        // STEP 1   GET CONNECTION OBJECT
        Connection conn = DriverManager.getConnection(url, username, password);

        // STEP 2 CREATE A STATEMENT OBJECT
        // AND WE WANT TO BE ABLE TO MOVE CURSOR EVERYWHERE


        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        // STEP 3    GET RESULT_SET BY RUNNING EXECUTE-QUERY METHOD OF STATEMENT OBJECT
        ResultSet rs = stmnt.executeQuery("select * from employees");

        ResultSetMetaData rsmd = rs.getMetaData();
        int totalColumnCount = rsmd.getColumnCount();
        System.out.println("totalColumnCount = " + totalColumnCount);

        String columnName = rsmd.getColumnName(1);
        System.out.println("columnName = " + columnName);

        for (int columnIndex = 1; columnIndex <= totalColumnCount ; columnIndex++) {
            System.out.print("columnIndex = " + columnIndex);
            System.out.println(" | Column name is " + rsmd.getColumnName(columnIndex));
        }

        // getting cell value using column index instead
        rs.next();
        System.out.println("rs.getString(\"EMPLOYEE_ID\") = " + rs.getString("EMPLOYEE_ID"));
        System.out.println("rs.getString(1) = " + rs.getString(1));
        System.out.println("rs.getString(2) = " + rs.getString(2));
        System.out.println("rs.getString(3) = " + rs.getString(3));

        //



        // print out entire first row

        for (int columnIndex = 1;columnIndex<= totalColumnCount;columnIndex++){

            System.out.println("rsmd.getColumnName("+ columnIndex +") = " + rsmd.getColumnName(columnIndex));


            System.out.println("rs.getString("+ columnIndex + ") = " + rs.getString(columnIndex));

        }






    }
}