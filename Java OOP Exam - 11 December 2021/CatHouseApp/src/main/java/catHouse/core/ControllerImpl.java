package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.Repository;
import catHouse.repositories.ToyRepository;

import java.util.LinkedHashMap;
import java.util.Map;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository toyRepository;
    private Map<String, House> houses;

    public ControllerImpl() {
        this.toyRepository = new ToyRepository();
        this.houses = new LinkedHashMap<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house = null;
        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                break;
        }
        if (house == null) {
            throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
        this.houses.put(house.getName(), house);
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy = null;
        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
        }
        if (toy == null) {
            throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        this.toyRepository.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy byType = this.toyRepository.findFirst(toyType);
        if (byType == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }
        this.houses.get(houseName).buyToy(byType);
        this.toyRepository.removeToy(byType);
        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        String lifeHouseType;
        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                lifeHouseType = "ShortHouse";
                break;
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                lifeHouseType = "LongHouse";
                break;
            default:
                throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }
        String houseType = this.houses.get(houseName).getClass().getSimpleName();
        if (lifeHouseType.equals(houseType)) {
            try {
                this.houses.get(houseName).addCat(cat);
            } catch (Exception e) {
                return e.getMessage();
            }
            return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, cat.getClass().getSimpleName(), houseName);
        } else {
            return String.format(UNSUITABLE_HOUSE);
        }
    }

    @Override
    public String feedingCat(String houseName) {
        this.houses.get(houseName).feeding();
        return String.format(FEEDING_CAT, this.houses.get(houseName).getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        double catPrice = houses.values().stream().filter(e->e.getName().equals(houseName))
                .mapToDouble(e -> e.getCats().stream().mapToDouble(Cat::getPrice).sum())
                .sum();
        double toyPrice = houses.values().stream().filter(e->e.getName().equals(houseName))
                .mapToDouble(e -> e.getToys().stream().mapToDouble(Toy::getPrice).sum())
                .sum();
        double sum = catPrice + toyPrice;
        return String.format(VALUE_HOUSE, houseName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        this.houses.values().forEach(e -> sb.append(e.getStatistics()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
