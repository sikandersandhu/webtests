package com.accesshq.tests.webtests;

import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTestSuite {

    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        // Set chrome driver path
        System.setProperty("webdriver.chrome.driver", Util.FIREFOX_PATH);
        // set WebDriver as chrome driver
        driver = new ChromeDriver();
        // go to website
        driver.get(Util.BASE_URL + "forms");
        // set window size to max
        driver.manage().window().maximize();
        // set implicit wait time
        driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
    }

    @AfterEach
    void tearDown() {
       /*if (driver != null){
            driver.quit();
       }*/
    }

    @Test
    void TestFormsPageSuccess() {

        //find name input element and enter name
        WebElement nameElement = driver.findElement(By.id("name"));
        nameElement.clear();
        nameElement.sendKeys("Sikander");

        // find email input element and enter email
        WebElement emailElement = driver.findElement(By.id("email"));
        emailElement.clear();
        emailElement.sendKeys("sikandersandhu82@gmail.com");

        // find State dropdown  a
        // nd select state [vic]
        driver.findElement(By.cssSelector(".v-select__selections")).click();   // find the state element and click
        driver.findElement(By.xpath("//*[contains(text(),'VIC')]")).click();   // find vic and click
        //driver.findElement(By.xpath("//div[@role='option'][2]")).click();    // xpath based on node

        // find and click on "do you agree" checkbox
        driver.findElement(By.cssSelector(".v-input--selection-controls__ripple")).click();

        // find submit button & click
        //driver.findElement(By.cssSelector("button[class='v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default'] ")).click();
        //driver.findElement(By.xpath("//span[normalize-space()='submit']")).submit();
        //submitForm();
    }

    // Leave all field blank. Only click submit
    @Test
    void TestFormPageFail(){
        submitForm();

        Assertions.assertEquals("Your name is required", driver.findElement(By.id("name-err")).getText());
        Assertions.assertEquals("Your email is required", driver.findElement(By.id("email-err")).getText());
        Assertions.assertEquals("You must agree to continue", driver.findElement(By.id("agree-err")).getText());

    }

    public void submitForm(){
        WebElement submitButton = null;
        // find all button elements, add them to a list
        var buttons = driver.findElements(By.tagName("button"));  // class = 'v-btn'

        // iterate the list, find the "submit" element
        for (WebElement button: buttons) {
            if (button.getText().equalsIgnoreCase("submit")) {
                submitButton = button;
                break;
            }
        }
        try{
            // if submit button found, press submit.
            if (submitButton != null){
                submitButton.click();
            }
            // If no submit button found, throw exception
            else{
                throw new NotFoundException();
            }
        }
        catch(NotFoundException nfe){
            System.out.println(nfe);
        }
    }
}





    // why does this not work ???????????????????

    //Select stateOpt = new Select();
    //selectState.selectByIndex(2);


    //Assertions.assertEquals("name", element.getAttribute("name").toLowerCase());
    //driver.findElement(By.cssSelector("[aria-label='forms']")).click();

