package com.accesshq.tests.webtests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class BaseTestSuite {

    protected WebDriver driver;
    protected Menu menu;

    @BeforeEach
    void setUp() {
        // Set chrome driver path
        System.setProperty("webdriver.chrome.driver", Util.CHROME_DRIVER_PATH);
        // set WebDriver as chrome driver
        driver = new ChromeDriver();
        // set window size to max
        driver.manage().window().maximize();
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
