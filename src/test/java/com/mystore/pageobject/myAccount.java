package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount {

    WebDriver ldriver;

    public myAccount (WebDriver rdriver) {

        ldriver = rdriver ;

        PageFactory.initElements(rdriver, this);

    }
//identifyWebElements

    @FindBy(id ="email_create")
    WebElement createEmailId;

    @FindBy(id ="SubmitCreate")
    WebElement SubmitCreate;
    //identify action on webElement

    @FindBy(id ="email")
    WebElement registeredEmail;

    @FindBy(id ="passwd")
    WebElement registeredPasswd;

    @FindBy(id = "SubmitLogin")
    WebElement submitLogin;

    @FindBy(xpath = "//span[normalize-space()='Abc Kumar']")
    WebElement userName;

    @FindBy(xpath = "//a[@title='Log me out']")
    WebElement logOut;


    public void selectLogOut(){

        logOut.click();

    }
    public String userInfo(){

        String text = userName.getText();
        return text;
    }



    public void enterEmailAddress(String emailAddress){

        registeredEmail.sendKeys(emailAddress);

    }

    public void enterPassword(String enterpawd){

        registeredPasswd.sendKeys(enterpawd);

    }

    public void clickToSignIn(){

        submitLogin.click();

    }
    public void enterCreateEmailAddress(String emailAdd){
        createEmailId.sendKeys(emailAdd);

    }

    public void clickSubmit(){
        SubmitCreate.click();

    }
}
