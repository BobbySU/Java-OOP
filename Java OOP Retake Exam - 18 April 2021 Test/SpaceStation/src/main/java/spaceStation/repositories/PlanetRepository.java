package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class PlanetRepository implements Repository<Planet>{
    private Map<String,Planet> planetMap;

    public PlanetRepository() {
        this.planetMap = new LinkedHashMap<>();
    }

    @Override
    public Collection<Planet> getModels() {
        return null;
    }

    @Override
    public void add(Planet model) {

    }

    @Override
    public boolean remove(Planet model) {
        return false;
    }

    @Override
    public Planet findByName(String name) {
        return null;
    }
}
