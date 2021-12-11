package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class AstronautRepository implements Repository<Astronaut>{
    private Map<String,Astronaut> astronautMap;

    public AstronautRepository() {
        this.astronautMap = new LinkedHashMap<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return null;
    }

    @Override
    public void add(Astronaut model) {

    }

    @Override
    public boolean remove(Astronaut model) {
        return false;
    }

    @Override
    public Astronaut findByName(String name) {
        return null;
    }
}
