package step_def;

import cucumber.api.java.Before;
import framework.base.Base;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static framework.base.DriverInterface.driver;



public class Browsers extends Base {

    @Before
    public static void startBrowserSession() throws IOException {



        Properties p = new Properties();
        FileInputStream fis = new FileInputStream( "src//main//java//framework//config//global.properties" );
        p.load( fis );
        p.getProperty( "browser" );

        if (p.getProperty( "browser" ).contains( "headless" ))

        {
            //File file = new File("C:/Test Environment/Tools/Browser/Phantomjs/bin/phantomjs.exe");
            //System.setProperty("phantomjs.binary.path", file.getAbsolutePath());

            System.setProperty( "phantomjs.binary.path", "src//main//java//framework//utilities//browserutil//phantomjs.exe" );

            //driver = new PhantomJSDriver();

        } else if (p.getProperty( "browser" ).contains( "firefox" ))

        {
            System.setProperty( "webdriver.gecko.driver", "src//main//java//framework//utilities//browserutil//geckodriver.exe" );
            FirefoxBinary firefoxBinary = new FirefoxBinary();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary( firefoxBinary );
            firefoxBinary.addCommandLineOptions( "--headless" );
            driver = new FirefoxDriver();

        } else if (p.getProperty( "browser" ).contains( "chrome" ))

        {
            System.setProperty( "webdriver.chrome.driver", "src//main//java//framework//utilities//browserutil//chromedriver.exe" );
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments( "--headless" );
            driver = new ChromeDriver( );

        } else if (p.getProperty( "browser" ).contains( "ie" ))

        {
            System.setProperty( "webdriver.ie.driver", "src//main//java//framework//utilities//browserutil//IEDriverServer.exe" );
            driver = new InternetExplorerDriver();
        }


    }

    @Test
    public static void maximizeWindow() {
        driver.manage().window().maximize();

    }

    @After
    public static void closeBrowserSession() {

        //Running test headlessly with @after method active impacts overall performance
        //Deactivate method before pushing code and set browser to headless in global properties
        driver.manage().deleteAllCookies();
        driver.close();
    }


}

