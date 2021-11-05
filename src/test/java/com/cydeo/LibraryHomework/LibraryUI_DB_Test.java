package com.cydeo.LibraryHomework;

import com.cydeo.LibraryHomework.pages.DashboardPage;
import com.cydeo.LibraryHomework.pages.LoginPage;
import com.cydeo.utility.ConfigReader;
import com.cydeo.utility.DB_Util;
import com.cydeo.utility.Driver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

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
    public void testLibrary_Users(){
        DB_Util.runQuery("select count(*) from users");
        String expectedResult_DB = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedResult_DB = " + expectedResult_DB);

        String actualResult_UI = "";
        LoginPage loginPage = new LoginPage();
        DashboardPage dashPage = new DashboardPage();

        Driver.getDriver().get(ConfigReader.read("library2.UI.url"));
        loginPage.login();

        actualResult_UI = dashPage.userCount.getText();
        System.out.println("actualResult_UI = " + actualResult_UI);

        Assertions.assertEquals(expectedResult_DB, actualResult_UI);

    }







    @AfterAll
    public static void teardown () {
        DB_Util.destroy();
    }



}
