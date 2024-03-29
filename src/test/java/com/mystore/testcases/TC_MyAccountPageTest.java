package com.mystore.testcases;

import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.myAddress;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

import static com.mystore.utilities.ExtentTestManager.reporterLog;

public class TC_MyAccountPageTest extends BaseClass {


    @Test(enabled = false)

    public void verifyRegistrationAndLogin() throws IOException {

        reporterLog("Url Opened");

        indexPage pg = new indexPage(driver);
        myAccount pg1 = new myAccount(driver);
        accountCreationDetails ac =new accountCreationDetails(driver);
        myAddress add = new myAddress(driver);


        pg.clickOnSignIn();
        pg1.enterCreateEmailAddress("abc10110@gmail.com");
        pg1.clickSubmit();

        ac.selectTitle();
        ac.custFirstName("abc");
        ac.custLattName("kumar");
        ac.enterPassword("Test@123");
        ac.registerCustomer();

        add.selectAddAddress();
        add.enterAddress("abcasd");
        add.enterCityName("Huwai");
        add.selectState("Alabama");
        add.enterPostcode("35013");
        add.enterPhoneNumber("324563245");
        add.enterMobileNumber("250324542");
        add.enterAddresstitle("Job");
        add.submitAddress();
        add.clickOnHome();


    }

    @Test (enabled = true)
    public void VerifyLogin() throws IOException {

        indexPage pg = new indexPage(driver);
        myAccount pg1 = new myAccount(driver);

        pg.clickOnSignIn();
        pg1.enterEmailAddress("abc1000@gmail.com");
        pg1.enterPassword("Test@123");
        pg1.clickToSignIn();

        String userName =pg1.userInfo();
        if (userName.equals("Abc Kumar")){
            Assert.assertTrue(true);

        }
        else {
            captureScreenshot(driver,"VerifyLogin");
            Assert.assertTrue(false);


        }


    }


}
