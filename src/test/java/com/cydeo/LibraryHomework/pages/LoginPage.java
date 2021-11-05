package com.cydeo.LibraryHomework.pages;

import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.ConfigReader;
import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "inputEmail")
    public WebElement email;

    @FindBy(id = "inputPassword")
    public WebElement password;

    @FindBy(xpath = "//button[@type = 'submit']")
    public WebElement signInBTN;

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void login() {

        email.sendKeys(ConfigReader.read("librarian1"));
        password.sendKeys(ConfigReader.read("password"));
        signInBTN.click();
        BrowserUtil.waitFor(3);
    }


}
