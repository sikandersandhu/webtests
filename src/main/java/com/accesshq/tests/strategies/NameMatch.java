package com.accesshq.tests.strategies;

import com.accesshq.tests.ui.PlanetTile;

public class NameMatch implements MatchingStrategy{

    String name;

    public NameMatch(String name){
        this.name = name;
    }

    @Override
    public boolean match(PlanetTile planetTile){
        if (planetTile.getPlanetName().equalsIgnoreCase(name)){
            return true;
        }
        return false;
    }
}
