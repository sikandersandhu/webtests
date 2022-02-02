package com.accesshq.tests.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormsPage {

    protected WebDriver driver;

    // Constructor | set WebDriver
    public FormsPage(WebDriver driver){
        this.driver = driver;
    }

    // get and set name methods
    public String getName(){
        return driver.findElement(By.id("name")).getText();
    }
    public void setName(String name){
        WebElement nameElement = driver.findElement(By.id("name"));
        nameElement.clear();
        nameElement.sendKeys(name);
    }

    //get and set email methods
    public String getEmail(){
        return driver.findElement(By.id("email")).getText();
    }
    public void setEmail(String email){
        WebElement emailElement = driver.findElement(By.id("email"));
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    // click on state method
    public void clickState(){
        driver.findElement(By.cssSelector(".v-select__selections")).click();
    }
    // select state
    public void selectState(States state){
        clickState();
        String xPathlocator = "//*[contains(text()," + state.toString() + ")]";
        driver.findElement(By.xpath(xPathlocator)).click();
    }

    // click agree method
    public void clickAgree(){
        driver.findElement(By.cssSelector(".v-input--selection-controls__ripple")).click();
    }

    // click submit method
    public void submitForm() {
        WebElement submitButton = null;
        // find all button elements, add them to a list
        var buttons = driver.findElements(By.tagName("button"));  // class = 'v-btn'

        // iterate the list, find the "submit" element
        for (WebElement button : buttons) {
            if (button.getText().equalsIgnoreCase("submit")) {
                submitButton = button;
                break;
            }
        }
        try {
            // if submit button found, press submit.
            if (submitButton != null) {
                submitButton.click();
            }
            // If no submit button found, throw exception
            else {
                throw new NotFoundException();
            }
        } catch (NotFoundException nfe) {
            System.out.println(nfe);
        }
    }

    // get error messages | name, email, checkbox
    public String getErrorMessageName(){
        return driver.findElement(By.id("name-err")).getText();
    }
    public String getErrorMessageEmail(){
        return driver.findElement(By.id("email-err")).getText();
    }
    public String getErrorMessageCheckBox(){
        return driver.findElement(By.id("agree-err")).getText();
    }

    // get popup message text
    public String createPopUpMessage() {
        return driver.findElement(By.cssSelector(".snackbar")).getText();
    }

    // check if pop up is visible
    public boolean isPopUpVisible() {
        return driver.findElement(By.cssSelector(".snackbar")).isDisplayed();
    }
}