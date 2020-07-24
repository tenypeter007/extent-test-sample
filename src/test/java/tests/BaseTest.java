package tests;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentTest;

import listeners.TestListener;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public static ExtentTest ChildTest;
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass (description = "Class Level Setup!")
    public void setup () {
        //Create a Chrome driver. All test classes use this.
        driver = new ChromeDriver();

        //Create a wait. All test classes use this.
        wait = new WebDriverWait(driver,15);

        //Maximize Window
        driver.manage().window().maximize();
    }
    
 

    @AfterClass(description = "Class Level Teardown!")
    public void teardown () {
        driver.quit();
    }

}
