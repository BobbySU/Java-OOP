package WildFarm03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] animalData = input.split("\\s+");
            Animal animal = getAnimal(animalData);

            String[] foodData = scanner.nextLine().split("\\s+");
            Food food = getFood(foodData);

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException invalidFood) {
                System.out.println(invalidFood.getMessage());
            }

            animals.add(animal);

            input = scanner.nextLine();
        }
        animals.forEach(System.out::println);
    }

    private static Food getFood(String[] foodData) {
        Food food;
        if (foodData[0].equals("Vegetable"))
            food = new Vegetable(Integer.parseInt(foodData[1]));
        else {
            food = new Meat(Integer.parseInt(foodData[1]));
        }
        return food;
    }

    private static Animal getAnimal(String[] input) {
        Animal animal = null;

        String type = input[0];
        String name = input[1];
        Double weight = Double.parseDouble(input[2]);
        String livingRegion = input[3];

        String breed = input.length == 5 ? input[4] : null;

        switch (type) {
            case "Cat":
                animal = new Cat(name, type, weight, livingRegion, breed);
                break;
            case "Tiger":
                animal = new Tiger(name, type, weight, livingRegion);
                break;
            case "Zebra":
                animal = new Zebra(name, type, weight, livingRegion);
                break;
            case "Mouse":
                animal = new Mouse(name, type, weight, livingRegion);
                break;
        }
        return animal;
    }
}

