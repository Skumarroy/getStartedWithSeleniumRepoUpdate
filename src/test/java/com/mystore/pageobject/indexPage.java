package com.mystore.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {

    //1.Create Object of WEBDRIVER

    WebDriver ldriver;

    // Constructor
    public indexPage (WebDriver rdriver) {

        ldriver = rdriver ;

        PageFactory.initElements(rdriver, this);

    }

    //identifyWebElements

    @FindBy(linkText ="Sign in")
    WebElement signIn;

    //identify action on webElement

    public void clickOnSignIn(){
        signIn.click();

    }

}
