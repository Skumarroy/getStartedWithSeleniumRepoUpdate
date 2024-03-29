package com.mystore.testcases;

import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.myAddress;
import com.mystore.utilities.ReadExcelFile;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_MyAccountPageTestDataDrivenTesting extends BaseClass {


    @Test(enabled = false)

    public void verifyRegistrationAndLogin() throws IOException {

        //logger.info("Url Opened");

        indexPage pg = new indexPage(driver);
        myAccount pg1 = new myAccount(driver);
        accountCreationDetails ac = new accountCreationDetails(driver);
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

    @Test(dataProvider = "LoginDataProvider")
    public void VerifyLogin(String userEmail, String userPassword, String userNames) throws IOException {

        indexPage pg = new indexPage(driver);
        myAccount pg1 = new myAccount(driver);

        pg.clickOnSignIn();
        pg1.enterEmailAddress(userEmail);
        pg1.enterPassword(userPassword);
        pg1.clickToSignIn();

        String userName = pg1.userInfo();
        if (userName.equals(userNames)) {
            Assert.assertTrue(true);

        } else {
            captureScreenshot(driver, "VerifyLogin");
            Assert.assertTrue(false);


        }

        pg1.selectLogOut();

    }

    @DataProvider(name = "LoginDataProvider")
    public String[][] LoginDataProvider() throws IOException {

        System.out.println(System.getProperty("user.dir"));
        String fileName = System.getProperty("user.dir") + "\\TestData\\MyStoreTestData.xlsx";

        int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
        int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");

        String data[][] = new String[ttlRows][ttlColumns];

        for (int i = 1; i < ttlRows; i++)  //rows =1, 2
        {

            for (int j = 1; j < ttlRows; j++)  //column =0,1, 2

            {
                data[i - 1][j] = ReadExcelFile.getCellValue(fileName, "LoginTestData", i, j);

            }

        }

        return data;

    }

}





