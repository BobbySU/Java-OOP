package Vehicles01;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] car1 = scan.nextLine().split(" ");
        double carFuelAmount = Double.parseDouble(car1[1]);
        double carConsumption = Double.parseDouble(car1[2]);
        Vehicles car = new Car(carFuelAmount, carConsumption);


        String[] truck1 = scan.nextLine().split(" ");
        double truckFuelAmount = Double.parseDouble(truck1[1]);
        double truckConsumption = Double.parseDouble(truck1[2]);
        Vehicles truck = new Truck(truckFuelAmount, truckConsumption);

        Map<String, Vehicles> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            String commandName = input[0];
            String vehicleType = input[1];

            switch (commandName) {
                case "Drive":
                    double distance = Double.parseDouble(input[2]);
                    System.out.println(vehicles.get(vehicleType).drive(distance));
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(input[2]);
                    vehicles.get(vehicleType).refuel(liters);
                    break;
                default:
                    throw new IllegalArgumentException("No such command");
            }
        }
        vehicles.values().forEach(System.out::println);
    }
}
