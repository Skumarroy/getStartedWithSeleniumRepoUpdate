package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class myAddress {

    //1.Create Object of WEBDRIVER

    WebDriver ldriver;

    // Constructor
    public myAddress (WebDriver rdriver) {

        ldriver = rdriver ;

        PageFactory.initElements(rdriver, this);

    }

    //identifyWebElements

    @FindBy(xpath ="//span[normalize-space()='Add my first address']")
    WebElement addMyFirstAddress;

    @FindBy(id ="address1")
    WebElement custAddress1;

    @FindBy(id ="city")
    WebElement cityName;

    @FindBy(id ="id_state")
    WebElement custState;

    @FindBy(id ="postcode")
    WebElement zipcode;

    @FindBy(id ="phone")
    WebElement homePhonNumber;

    @FindBy(id ="phone_mobile")
    WebElement custmobileNumber;

    @FindBy(id = "alias")

    WebElement anAddresstitle;

    @FindBy(id = "submitAddress")

    WebElement saveAddress;

    @FindBy(xpath = "//span[normalize-space()='Home']")
    WebElement selectHome;

    //identify action on webElement

    public void selectAddAddress(){
        addMyFirstAddress.click();

    }

    public void enterAddress(String custAddName){
        custAddress1.sendKeys(custAddName);

    }
    public void enterCityName(String custCityName){
        cityName.sendKeys(custCityName);

    }
    public void selectState(String text){

        Select obj = new Select(custState);
        obj.selectByVisibleText(text);

    }

    public void enterPostcode(String postcode){
        zipcode.sendKeys(postcode);

    }

    public void enterPhoneNumber(String phoneNumber){
        homePhonNumber.sendKeys(phoneNumber);

    }

    public void enterMobileNumber(String mobileNumber){
        custmobileNumber.sendKeys(mobileNumber);

    }

    public void enterAddresstitle(String addresstitle){
        anAddresstitle.sendKeys(addresstitle);

    }

    public void submitAddress(){
        saveAddress.click();

    }

    public void clickOnHome(){
        selectHome.click();

    }
}

