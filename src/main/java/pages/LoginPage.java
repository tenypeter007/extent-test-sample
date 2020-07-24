package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

public class LoginPage extends BasePage {

    //*********Constructor*********
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //*********Web Elements*********
    String usenamexpath = "//SPAN[text()='Email']";
    String passwordxpath = "(//SPAN[text()='Password'])[1]";
    String usernameInputxpath = "(//INPUT[@type='email'])[1]";
    String passwordInputxpath = "//INPUT[@type='password']";
    String loginButtonxpath = "//BUTTON[text()='Login']";
    String errorMessageUsernameClass = "resultlogin";
    String errorMessagePasswordXpath = "//*[@id=\"loginForm\"]/div[2]/div/div";

    //*********Page Methods*********
    public void loginToN11 (String username, String password){
        //Enter Username(Email)
    	click(By.xpath(usenamexpath));
        writeText(By.xpath(usernameInputxpath),username);
        //Enter Password
        click(By.xpath(passwordxpath));
        writeText(By.xpath(passwordInputxpath), password);
        //Click Login Button
        click(By.xpath(loginButtonxpath));
    }

    //Verify Username Condition
    public void verifyLoginUserName (String expectedText,ExtentTest test) {
        Assert.assertEquals(readText(By.className(errorMessageUsernameClass)), expectedText);
        
    }

    //Verify Password Condition
    public void verifyLoginPassword (String expectedText, ExtentTest test) {
        Assert.assertEquals(readText(By.className(errorMessageUsernameClass)), expectedText);
     
    }

}
