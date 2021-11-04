package com.cydeo.day2;

import java.sql.*;

public class LoopingBackward {
    public static void main(String[] args) throws SQLException {

        // run


        String url = "jdbc:oracle:thin:@54.236.150.168:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmnt.executeQuery("SELECT * FROM EMPLOYEES where employee_id<120");
        ResultSetMetaData rsmd = rs.getMetaData();
//  print out employee id column from last row till first row

        rs.afterLast();

        while(rs.previous()){
            System.out.println("rs.getString(1) = " + rs.getString(1));

        }
        // after we done with the connection we need to close them
        // just like scanner , FileInputStream and so on

        rs.close();
        stmnt.close();
        conn.close();


    }
}
