package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    //*********Constructor*********
    public HomePage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //*********Page Variables*********
    String baseURL = "https://www.phptravels.net/home";

    //*********Web Elements*********
    String signInButtonXpath = "//A[@class='dropdown-item active tr'][text()='Login']";

    String signInMainButtonId = "(//A[@id='dropdownCurrency'])[2]";

    //*********Page Methods*********

    //Go to Homepage
    public void goToN11 (){
        driver.get(baseURL);
        //driver.navigate().to(baseURL)
    }

    //Go to LoginPage
    public void goToLoginPage (){
        click(By.xpath(signInMainButtonId));
        click(By.xpath(signInButtonXpath));
    }

}
