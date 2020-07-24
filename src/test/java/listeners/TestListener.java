package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;
import tests.LoginTests;
import utilities.ExtentManager;
import org.openqa.selenium.TakesScreenshot;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;


public class TestListener extends BaseTest implements ITestListener {

    //Extent Report Declarations
    private static ExtentReports extent = ExtentManager.createInstance();
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static String screenshotPath = System.getProperty("user.dir")+ "/Screenshots";
   
    @Override
    public synchronized void onStart(ITestContext context) {
        System.out.println("Extent Reports Version 3 Test Suite started!");
      
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        System.out.println(("Extent Reports Version 3  Test Suite is ending!"));
        extent.flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " started!"));
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        test.set(extentTest);
        
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " passed!"));
        test.get().pass("Test passed");
        
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " failed!"));
        test.get().fail(result.getThrowable());
        BaseTest.ChildTest.fail("Failed");
       
        try{
         	 // To create reference of TakesScreenshot
        	BaseTest b = (BaseTest) result.getInstance();
         	
         	 TakesScreenshot screenshot=(TakesScreenshot)b.driver;
         	 // Call method to capture screenshot
         	 File src=screenshot.getScreenshotAs(OutputType.FILE);
         	 // Copy files to specific location 
         	 // result.getName() will return name of test case so that screenshot name will be same as test case name
         	 FileUtils.copyFile(src, new File(screenshotPath+"/"+result.getName()+".png"));
         	 System.out.println("Successfully captured a screenshot");
         	 }catch (Exception e){
         	 System.out.println("Exception while taking screenshot "+e.getMessage());
         	 } 
        try {
			test.get().fail("details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath+"/"+result.getName()+".png").build());
		
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " skipped!"));
        test.get().skip(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }
}
