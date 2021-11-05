package PizzaCalories04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Pizza pizza;
        Dough dough;

        String[] inputPizza = scan.nextLine().split("\\s+");
        try {
            pizza = new Pizza(inputPizza[1], Integer.parseInt(inputPizza[2]));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String[] doughInput = scan.nextLine().split("\\s+");
        try {
            dough = new Dough(doughInput[1], doughInput[2], Double.parseDouble(doughInput[3]));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        pizza.setDough(dough);

        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] topping = input.split("\\s+");
            try {
                pizza.addTopping(new Topping(topping[1], Double.parseDouble(topping[2])));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
            input = scan.nextLine();
        }
        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
    }
}
