package com.mystore.utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentListenersClass implements ITestListener {

    ExtentSparkReporter htmlReporter;
    ExtentReports reports;

    ExtentTest test;

    public void configureReport(){

        String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh_mm_ss").format(new Date());
        String reportName = "MyStoreTestReport-" + timestamp + ".html";

        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
        reports =new ExtentReports();
        reports.attachReporter(htmlReporter);

        //add system information/environment information
        reports.setSystemInfo("Machine:","teetpc1");
        reports.setSystemInfo("OS:","Windows 11");
        reports.setSystemInfo("browser:","chrome");
        reports.setSystemInfo("user name:","abc");

        //configure to change look and feel of reports

        htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
        htmlReporter.config().setReportName("This is my 1st Report");
        htmlReporter.config().setTheme(Theme.DARK);

    }
//On start Method is called When any test  starts
    public  void onStart(ITestContext Result){

        configureReport();
        System.out.println("On start Method Evoke");

    }

    //on finished Method is called after all  tests are executed

    public  void onFinish(ITestContext Result) {

        System.out.println("On Finsihed Method Evoke");
        reports.flush();

    }


        //When Test case get failed this method is called

    public  void onTestFailure(ITestResult Result){

        System.out.println("Name of the Test Method Failed:"+Result.getName());
        test=reports.createTest(Result.getName());
        test.log(Status.FAIL, MarkupHelper.createLabel("Name of the Failed test case is :"+Result.getName(), ExtentColor.RED));

        String screenshotpath =System.getProperty("user.dir")+"\\Screenshots\\"+Result.getName()+".png";

        File screenshotFile = new File(screenshotpath);

        if (screenshotFile.exists()){
            test.fail("Capture Screenhot is below "+ test.addScreenCaptureFromPath(screenshotpath));
        }
        //Capture Screen shots
        //test.addScreenCaptureFromPath("");


    }

    //When Test get skipped,this method call

    public  void onTestSkipped(ITestResult Result){

        System.out.println("Name of the Test Method Failed:"+Result.getName());
        test=reports.createTest(Result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel("Name of the SKIP test case is :"+Result.getName(), ExtentColor.YELLOW));

    }

    //When Test get Passed,this method call

    public  void onTestSuccess(ITestResult Result){

        System.out.println("Name of the Test Method Successfully Executed :"+Result.getName());
        test=reports.createTest(Result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel("Name of the succeeed test case is :"+Result.getName(), ExtentColor.GREEN));

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult Result){

    }
}
