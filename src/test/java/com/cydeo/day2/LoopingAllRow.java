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
        Statement stmnt = conn.createStatement();

        // STEP 3    GET RESULT_SET BY RUNNING EXECUTE-QUERY METHOD OF STATEMENT OBJECT
        ResultSet rs = stmnt.executeQuery("select * from regions");


    }
}
