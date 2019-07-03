package framework.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static framework.base.DriverInterface.driver;

public class BasePage extends Base {

    //ELEMENTS
    private By signInLink = By.cssSelector(".site-header__link");

    //VALIDATION
    private static By register_signIn_lnk= By.cssSelector("body > header > div > div:nth-child(4) > div > span");

    //METHODS
    public void clickSignInLink(){

        List<WebElement> signIn = driver.findElements(signInLink );
        signIn.get(1).click();
    }

    public static String getUserName(){

        WebElement usrname = driver.findElement(register_signIn_lnk );
        return  usrname.getText();
    }








}


