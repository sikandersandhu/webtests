package com.accesshq.tests.strategies;

import com.accesshq.tests.ui.PlanetTile;

public class RadiusMatch implements MatchingStrategy{

    double radius;

    public RadiusMatch(double radius){
        this.radius = this.radius;
    }

    @Override
    public boolean match(PlanetTile planetTile){
        if (planetTile.getDoubleRadius() == radius){
            return true;
        }
        return false;
    }
}
