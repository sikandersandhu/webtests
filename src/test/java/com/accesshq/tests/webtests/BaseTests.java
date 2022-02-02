package com.accesshq.tests.webtests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    protected WebDriver driver;
    protected Menu menu;

    @BeforeEach
    void setUp() throws MalformedURLException {
        // Set chrome driver path
        //System.setProperty("webdriver.chrome.driver", Util.CHROME_DRIVER_PATH);
        // set WebDriver as chrome driver
        //driver = new ChromeDriver();
        // set window size to max
        //driver.manage().window().maximize();

        // Selenium grid to run tests in multiple browsers | parallel testing

        var chromeOptions = new ChromeOptions();
        //var firefoxOptions = new FirefoxOptions();
        driver = new RemoteWebDriver (new URL("http://localhost:4444/wd/hub"), chromeOptions);
        //driver = new RemoteWebDriver (new URL("http://localhost:4444/wd/hub"), firefoxOptions);


        // set implicit wait time
        // this approach keeps checking if action is done, if done it will exit prior to time time out set
        driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
        // set menu
        menu = new Menu(driver);
    }

    @AfterEach
    void tearDown() {
       if (driver != null){
           driver.quit();
       }
    }
}
