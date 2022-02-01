package com.accesshq.tests.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PlanetTile {

    protected WebElement element;

    public PlanetTile(WebElement elem) {
        this.element = elem;
    }

    public String getPlanetName(){
        return element.findElement(By.tagName("h2")).getText();
    }

    // get as string planets: distance , radius
    public String getStringDistance(){  return element.findElement(By.className("distance")).getText(); }
    public String getStringRadius() { return element.findElement(By.className("radius")).getText(); }

    // convert string to double
    public double parseToDouble(String strValue){
        double doubleValue = 0.0;
        try{
            strValue = strValue.replaceAll("[^\\d.]", "");
            doubleValue = Double.parseDouble(strValue);
        }
        catch(Exception e){
            System.out.println("Could not parse string to double. \nException: " + e);
        }
        return doubleValue;
    }

    // get as double planets: distance, radius
    public double getDoubleDistance() { return parseToDouble(getStringDistance()); }
    public double getDoubleRadius() { return parseToDouble(getStringRadius()); }
}
