package com.accesshq.tests.webtests;

import com.accesshq.tests.strategies.DistanceMatch;
import com.accesshq.tests.strategies.NameMatch;
import com.accesshq.tests.strategies.RadiusMatch;
import com.accesshq.tests.ui.PlanetTile;
import com.accesshq.tests.ui.PlanetsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlanetsTestsSuite extends BaseTestSuite{

    @Test
    void assertPlanetName(){

        //arrange

        // open planets page
        var myMenu = new Menu(driver);
        myMenu.clickPlanets();
        // create planets page object
        var planetPage = new PlanetsPage(driver);

        // ACT

        // find planet tile by name
        PlanetTile planet = planetPage.getPlanetTile(new NameMatch("Jupiter"));

        // ASSERT

        // actual and expected names match
        Assertions.assertEquals("Jupiter", planet.getPlanetName());
        // actual and expected planet distance match
        Assertions.assertEquals(778500000, planet.getDoubleDistance());
        // actual and expected planet radius match
        Assertions.assertEquals(69911, planet.getDoubleRadius());

        // Excercise

        // find planet 108200000 kms from sun
        planet = planetPage.getPlanetTile(new DistanceMatch(108200000));
        System.out.println(planet.getPlanetName() + " is 108,200,000kms away from the sun.");

        // find planet furthest from the sun
        planet = planetPage.getPlanetTile(new DistanceMatch(planetPage.getPlanetByMeasurement(FindByMeasurements.GREATEST_DIST)));
        System.out.println("The planet furthermost from the sun is " + planet.getPlanetName() + " at " + planet.getStringDistance() + ".");

        // find planet closest from the sun
        planet = planetPage.getPlanetTile(new DistanceMatch(planetPage.getPlanetByMeasurement(FindByMeasurements.SHORTEST_DIST)));
        System.out.println("The planet closest to the sun is " + planet.getPlanetName() + " at " + planet.getStringDistance() + ".");

        // find planet with the greatest radius
        planet = planetPage.getPlanetTile(new RadiusMatch(planetPage.getPlanetByMeasurement(FindByMeasurements.GREATEST_RADIUS)));
        System.out.println("The planet with the greatest radius is " + planet.getPlanetName() + " at " + planet.getStringRadius() + ".");

        // find planet with the smallest radius
        planet = planetPage.getPlanetTile(new RadiusMatch(planetPage.getPlanetByMeasurement(FindByMeasurements.SHORTEST_RADIUS)));
        System.out.println("The planet closest to the sun is " + planet.getPlanetName() + " at " + planet.getStringRadius() + ".");
    }

    /*@Test
    void planetFurthestDistance(){
        //arrange

        // open planets page
        var myMenu = new Menu(driver);
        myMenu.clickPlanets();
        // create planets page object
        var planetPage = new PlanetsPage(driver);

        PlanetTile planet;

        // find planet furthest from the sun
        planet = planetPage.getPlanetTile(new DistanceMatch(planetPage.getPlanetByMeasurement(FindByMeasurements.GREATEST_DIST)));
        System.out.println("The planet furthermost from the sun is " + planet.getPlanetName() + " at " + planet.getStringDistance() + ".");
    }*/
}