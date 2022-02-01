package com.accesshq.tests.ui;

import com.accesshq.tests.strategies.MatchingStrategy;
import com.accesshq.tests.webtests.FindByMeasurements;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PlanetsPage {

    WebDriver driver;
    PlanetTile currPlanet;


    public PlanetsPage(WebDriver driver){
        this.driver = driver;
    }

    public PlanetTile getPlanetTile(MatchingStrategy strategy){

        var planetTiles = driver.findElements(By.className("planet"));

        // loop through the list and find planet tile
        for (WebElement tile : planetTiles) {

            PlanetTile planet = new PlanetTile(tile);

            //is the requested planet in the list
            if (strategy.match(planet)) {
                return planet;
            }
        }
        throw (new NotFoundException("planet not found"));
    }

    private double getShortestDist(List<WebElement> tiles) {

        // variable to hold min value
        double minValue = Double.MAX_VALUE;

        // inspect each tile using the service of PlanetTile object
        for (WebElement tile : tiles) {
            PlanetTile planetTile = new PlanetTile(tile);

            // if the current value greater than current tiles distance
            if (minValue > planetTile.getDoubleDistance()) {
                // assign the current planet distance to value
                // as we are looking for shortest distance
                minValue = planetTile.getDoubleDistance();
            }
        }
        return minValue;
    }
    private double getShortestRadius(List<WebElement> tiles) {

        // variable to hold min value
        double minValue = Double.MAX_VALUE;

        // inspect each tile using the service of PlanetTile object
        for (WebElement tile : tiles) {
            PlanetTile planetTile = new PlanetTile(tile);

            // if the current value greater than current tiles distance
            if (minValue > planetTile.getDoubleRadius()) {
                // assign the current planet distance to value
                // as we are looking for shortest distance
                minValue = planetTile.getDoubleRadius();
            }
        }
        return minValue;
    }
    private double getGreatestDist(List<WebElement> tiles) {

        // variable to hold min value
        double maxValue = 0;

        // inspect each tile using the service of PlanetTile object
        for (WebElement tile : tiles) {
            PlanetTile planetTile = new PlanetTile(tile);

            // if the current value greater than current tiles distance
            if (maxValue < planetTile.getDoubleDistance()) {
                // assign the current planet distance to value
                // as we are looking for shortest distance
                maxValue = planetTile.getDoubleDistance();
            }
        }
        return maxValue;
    }
    private double getGreatestRadius(List<WebElement> tiles) {

        // variable to hold min value
        double maxValue = 0;

        // inspect each tile using the service of PlanetTile object
        for (WebElement tile : tiles) {
            PlanetTile planetTile = new PlanetTile(tile);

            // if the current value greater than current tiles distance
            if (maxValue < planetTile.getDoubleRadius()) {
                // assign the current planet distance to value
                // as we are looking for shortest distance
                maxValue = planetTile.getDoubleRadius();
            }
        }
        return maxValue;
    }

    public double getPlanetByMeasurement(FindByMeasurements findBy){

        // create a list of all tiles
        var planetTiles = driver.findElements(By.className("planet"));

        // if finding by shortest distance
        if (findBy == FindByMeasurements.SHORTEST_DIST){
            return getShortestDist(planetTiles);
        }
        // if finding by shortest radius
        else if (findBy == FindByMeasurements.SHORTEST_RADIUS){
            return getShortestRadius(planetTiles);
        }
        // if finding by greatest distance
        else if (findBy == FindByMeasurements.GREATEST_DIST){
            return getGreatestDist(planetTiles);
        }
        // if finding by greatest radius
        else { return getGreatestRadius(planetTiles); }
    }
}