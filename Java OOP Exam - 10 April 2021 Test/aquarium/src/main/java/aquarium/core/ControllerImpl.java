package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;
import aquarium.repositories.Repository;

import java.util.LinkedHashMap;
import java.util.Map;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository decorationRepository;
    private Map<String, Aquarium> aquariums;

    public ControllerImpl() {
        this.decorationRepository = new DecorationRepository();
        this.aquariums = new LinkedHashMap<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium = null;
        switch (aquariumType) {
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;
        }
        if (aquarium == null) {
            throw new IllegalArgumentException(INVALID_AQUARIUM_TYPE);
        }
        this.aquariums.put(aquarium.getName(), aquarium);
        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration = null;
        switch (type) {
            case "Ornament":
                decoration = new Ornament();
                break;
            case "Plant":
                decoration = new Plant();
                break;
        }
        if (decoration == null) {
            throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        decorationRepository.add(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration byType = this.decorationRepository.findByType(decorationType);
        if (byType == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }
        this.aquariums.get(aquariumName).addDecoration(byType);
        this.decorationRepository.remove(byType);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;
        String lifeAquariumType;

        switch (fishType) {
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName, fishSpecies, price);
                lifeAquariumType = "FreshwaterAquarium";
                break;
            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName, fishSpecies, price);
                lifeAquariumType = "SaltwaterAquarium";
                break;
            default:
                throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }
        String aquariumType = this.aquariums.get(aquariumName).getClass().getSimpleName();

        if (lifeAquariumType.equals(aquariumType)) {
            try {
                this.aquariums.get(aquariumName).addFish(fish);
            } catch (Exception e) {
                return e.getMessage();
            }
            return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fish.getClass().getSimpleName(), aquariumName);
        } else {
            return String.format(WATER_NOT_SUITABLE);
        }
    }

    @Override
    public String feedFish(String aquariumName) {
        this.aquariums.get(aquariumName).feed();
        return String.format(FISH_FED, this.aquariums.get(aquariumName).getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        double fishesPrice = aquariums.values().stream()
                .mapToDouble(e -> e.getFish().stream().mapToDouble(Fish::getPrice).sum())
                .sum();
        double decorationPrice = aquariums.values().stream()
                .mapToDouble(e -> e.getDecorations().stream().mapToDouble(Decoration::getPrice).sum())
                .sum();
        double sum = fishesPrice + decorationPrice;
        return String.format(VALUE_AQUARIUM, aquariumName, sum);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        this.aquariums.values().forEach(e -> sb.append(e.getInfo()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
