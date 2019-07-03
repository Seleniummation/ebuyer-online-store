package pages;

import framework.base.Base;
import org.openqa.selenium.support.ui.WebDriverWait;

import static framework.base.DriverInterface.driver;

public class LandingPage extends Base{

    private static WebDriverWait wait;

    public void launchUrl(){

        driver.manage().deleteAllCookies();
        //Browsers.maximizeWindow();
        driver.get("https://www.ebuyer.com/");

    }


}
