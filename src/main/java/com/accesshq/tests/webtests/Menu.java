package com.accesshq.tests.webtests;

import org.openqa.selenium.WebDriver;


public class Menu {

    private WebDriver driver;
    public static final String BASE_URL = "https://d18u5zoaatmpxx.cloudfront.net/#/";


    public Menu(WebDriver driver){
        this.driver = driver;
    }

    public void clickForms(){
        driver.get(BASE_URL + "forms");
    }

    public void clickPlanets(){
        driver.get(BASE_URL + "planets");
    }

    public void clickHome(){
        driver.get(BASE_URL);
    }
}
