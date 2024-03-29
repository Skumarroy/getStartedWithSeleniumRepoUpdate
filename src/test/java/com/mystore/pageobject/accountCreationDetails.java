package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountCreationDetails {

    //1.Create Object of WEBDRIVER

    WebDriver ldriver;

    // Constructor
    public accountCreationDetails (WebDriver rdriver) {

        ldriver = rdriver ;

        PageFactory.initElements(rdriver, this);

    }

    //identifyWebElements

    @FindBy(id ="id_gender1")
    WebElement title;

    @FindBy(id ="customer_firstname")
    WebElement custfirstname;

    @FindBy(id ="customer_lastname")
    WebElement custlasttname;

    @FindBy(id ="passwd")
    WebElement password;

    @FindBy(id ="submitAccount")
    WebElement register;

    //identify action on webElement

    public void selectTitle(){
        title.click();

    }

    public void custFirstName(String custFirstName){
        custfirstname.sendKeys(custFirstName);

    }

    public void custLattName(String custLaststName){
        custlasttname.sendKeys(custLaststName);

    }

    public void enterPassword(String psw){
        password.sendKeys(psw);

    }

    public void registerCustomer(){
            register.click();

    }
}
