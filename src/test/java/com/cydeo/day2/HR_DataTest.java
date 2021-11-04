package com.cydeo.day2;

import com.cydeo.utility.ConfigReader;
import com.cydeo.utility.DB_Util;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HR_DataTest {


        // Connection creation need to be only performed once
        // so @BeforeAll method is good place to put ot

        @BeforeAll
        public static void init () {

            // Create connection to Oracle Database
            String url = ConfigReader.read("hr.database.url");
            String username = ConfigReader.read("hr.database.username");
            ;
            String password = ConfigReader.read("hr.database.password");
            ;

            DB_Util.createConnection(url, username, password);

        }

        @Test
        public void testRegion() {

            // read the first row of Regions table and verify REGION NAME is Europe
            DB_Util.runQuery("select*from regions");


            String firstRegion = DB_Util.getCellValue(1,"REGION_NAME");
            Assertions.assertEquals("Europe", firstRegion);

        }






        // Write a test to verify the max salary holder name is Steven King;
@Test
    public void testEmployee(){
        String query = "SELECT FIRST_NAME || ' '|| LAST_NAME  FROM EMPLOYEES " +
                "WHERE SALARY = (SELECT MAX(SALARY) FROM EMPLOYEES ) " ;

        DB_Util.runQuery(query);
        String expectedResult = "Steven King";
        String actualResult = DB_Util.getFirstRowFirstColumn();
    System.out.println("actualResult = " + actualResult);

    Assertions.assertEquals(expectedResult, actualResult);


    }

    // Closing creation need to be only performed once
    // so @AfterAll method is good place to put ot
    @AfterAll
    public static void teardown () {
        DB_Util.destroy();
    }
    /**
     * Create a new class called LibraryUI_BD_Test
     *
     * Add @BeforeAll and @AfterAll section to create and destoy connection
     *
     * Write a query to get the numbers on Library Dashboard page to get
     * expectedUserCount , expectedBookCount, expectedBorrowedBookCount
     *
     * Get Actual Result by going to the Chrome Browser using selenium and capture
     * actualUserCount , actualBookCount, actualBorrowedBookCount
     *
     * Assert they actually match !@!!!
     */

}
