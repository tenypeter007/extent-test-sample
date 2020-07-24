package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import listeners.TestListener;
import pages.HomePage;
import pages.LoginPage;

import java.lang.reflect.Method;


public class LoginTests extends BaseTest {

    //Test Data
    String wrongUsername = "teny@das.com";
    String wrongPassword = "11122233444";


    @Test (priority = 0, description="Invalid Login Scenario with wrong username and password.")
    public void invalidLoginTest_InvalidUserNameInvalidPassword ()  {
    	  try {
        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);
      //  TestListener.test 
        ChildTest=  TestListener.test.get().createNode("Navigate to Home page");
        //*************PAGE METHODS********************
        //Open N11 HomePage
        homePage.goToN11();
       
        //Go to LoginPage
        ChildTest=  TestListener.test.get().createNode("Navigate to Login page");
        homePage.goToLoginPage();

        //Login to N11
        ChildTest= TestListener.test.get().createNode("Login with wrong credentials");
        loginPage.loginToN11(wrongUsername, wrongPassword);

        //*************ASSERTIONS***********************
        ChildTest=   TestListener.test.get().createNode("Verify Test");

      
			Thread.sleep(3000);
			loginPage.verifyLoginPassword("Invalid Email or Password-error",ChildTest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ChildTest.fail(e);
			e.printStackTrace();
		}
        
    }

    @Test (priority = 1, description="Invalid Login Scenario with empty username and password.")
    public void invalidLoginTest_EmptyUserEmptyPassword ()  {

    	try { //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

        //*************PAGE METHODS********************
        ChildTest=  TestListener.test.get().createNode("Navigate to Home page");
        homePage.goToN11();
        
        ChildTest=  TestListener.test.get().createNode("Navigate to Login page");
        homePage.goToLoginPage();
        ChildTest= TestListener.test.get().createNode("Login with Empty credentials");
        loginPage.loginToN11("","");

        //*************ASSERTIONS***********************
        
			Thread.sleep(3000);
			  ChildTest=   TestListener.test.get().createNode("Verify Test");
			  loginPage.verifyLoginUserName("Invalid Email or Password",ChildTest);
			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ChildTest.fail(e);
			e.printStackTrace();
		}
      
      //  loginPage.verifyLoginPassword("WRONG MESSAGE FOR FAILURE!");
    }

}
