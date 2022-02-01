package com.accesshq.tests.strategies;

import com.accesshq.tests.ui.PlanetTile;

public class DistanceMatch implements MatchingStrategy{

    double distance;

    public DistanceMatch(double distance){
        this.distance = distance;
    }

    @Override
    public boolean match(PlanetTile planetTile){
        if (planetTile.getDoubleDistance() == distance){
            return true;
        }
        return false;
    }
}
