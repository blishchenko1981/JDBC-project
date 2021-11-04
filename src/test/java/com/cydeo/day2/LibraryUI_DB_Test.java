package com.cydeo.day2;

import com.cydeo.utility.ConfigReader;
import com.cydeo.utility.DB_Util;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LibraryUI_DB_Test {
    @BeforeAll
    public static void init () {

        // Create connection to Library Database
        String url = ConfigReader.read("library2.database.url");
        String username = ConfigReader.read("library2.database.username");
        ;
        String password = ConfigReader.read("library2.database.password");
        ;

        DB_Util.createConnection(url, username, password);

    }


    @Test
    public void testLibrary(){
        DB_Util.runQuery("select count(*) from users");
        String expectedResult_DB = DB_Util.getFirstRowFirstColumn();

        String actualResult_UI = "";

    }







    @AfterAll
    public static void teardown () {
        DB_Util.destroy();
    }



}
