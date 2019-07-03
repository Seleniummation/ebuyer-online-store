package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import static framework.base.DriverInterface.driver;

public class CustomerAccount {

    //ELEMENTS

    private By email_txt = By.name("email");
    private By password_txt = By.id("password");
    private By signIn_btn = By.id("login");

    //VALIDATION
    private static By signIn_or_register_txt = By.cssSelector("#login > h2:nth-child(4)");



    //METHODS
    public void setEmail(String email_address){

        driver.findElement(email_txt).sendKeys(email_address);
    }

    public void setPassword(String password){

        driver.findElement(password_txt).sendKeys(password);
    }

    public void submitForm(){

        driver.findElement(signIn_btn).submit();
    }

    public static String getSignInOrRegisterText(){

        WebElement signInRegister =driver.findElement(signIn_or_register_txt);
        return signInRegister.getText();
    }


}
