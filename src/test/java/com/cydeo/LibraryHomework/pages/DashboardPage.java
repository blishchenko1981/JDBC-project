package com.cydeo.LibraryHomework.pages;

import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    @FindBy(xpath = "//h2[@id = 'user_count']")
    public WebElement userCount;

    @FindBy(xpath = "//h2[@id = 'book_count']")
    public WebElement bookCount;

    @FindBy(xpath = "//h2[@id = 'borrowed_books']")
    public WebElement borrowedooBooks;

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }






}
