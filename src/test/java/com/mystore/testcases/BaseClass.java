package com.mystore.testcases;

import com.mystore.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.bouncycastle.oer.Switch;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static com.mystore.utilities.ExtentTestManager.reporterLog;
import static java.time.Duration.*;

public class BaseClass {

    //Now We need to read the re-usable data from properties ReadConfig class
    //creating object for ReadConfig in BaseClass

    ReadConfig readConfig =new ReadConfig();
    String url =readConfig.getBaseUrl();
    String browser=readConfig.getBrowser();
    public  static WebDriver driver;

    public static Logger logger;

    @BeforeClass

    public void setup(){

        String browser ="chrome";

        switch (browser.toLowerCase()){

            case "chrome":

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "msedge":

                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            case "firefox":

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                driver=null;
                break;
        }
//impliciteWait of 10 secs for all webelment
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //WIndow maximize
        driver.manage().window().maximize();

//for loging data information we are using log4j2

        reporterLog("message sent");

      // Logger =LogManager.getLogger("MyStoreV1");

        driver.get(url);
    }

    @AfterClass

    public void tearDown()
    {
        driver.close();
        driver.quit();
    }

    public void captureScreenshot(WebDriver driver, String testName) throws IOException {
//Step 1:- convert Webdriver object to Screnshot Interface

        TakesScreenshot screenshot=((TakesScreenshot)driver);

        //Step 2:- Call get Screenshots as method  to create image file

        File src =screenshot.getScreenshotAs(OutputType.FILE);

        File destination = new File(System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png");

        FileUtils.copyFile(src,destination);

    }
}
