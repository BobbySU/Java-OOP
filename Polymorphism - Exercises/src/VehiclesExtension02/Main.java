package VehiclesExtension02;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] parameters = scan.nextLine().split(" ");
        Vehicles car = setVehicl(parameters);

        parameters = scan.nextLine().split(" ");
        Vehicles truck = setVehicl(parameters);

        parameters = scan.nextLine().split(" ");
        Vehicles bus = setVehicl(parameters);

        Map<String, Vehicles> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            String commandName = input[0];
            String vehicleType = input[1];
            try {
                switch (commandName) {
                    case "Drive":
                        double distance = Double.parseDouble(input[2]);
                        System.out.println(vehicles.get(vehicleType).drive(distance));
                        break;
                    case "Refuel":
                        double liters = Double.parseDouble(input[2]);
                        vehicles.get(vehicleType).refuel(liters);
                        break;
                    case "DriveEmpty":
                        double litersEmpty = Double.parseDouble(input[2]);
                        System.out.println(((Bus) bus).driveEmpty(litersEmpty));
                        break;
                    default:
                        throw new IllegalArgumentException("No such command");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        vehicles.values().forEach(System.out::println);
    }

    private static Vehicles setVehicl(String[] parameters) {
        String vehicleType = parameters[0];
        double fuelAmount = Double.parseDouble(parameters[1]);
        double consumption = Double.parseDouble(parameters[2]);
        double tankCapacity = Double.parseDouble(parameters[3]);
        Vehicles vehicles = null;
        switch (vehicleType) {
            case "Car":
                vehicles = new Car(fuelAmount, consumption, tankCapacity);
                break;
            case "Bus":
                vehicles = new Bus(fuelAmount, consumption, tankCapacity);
                break;
            case "Truck":
                vehicles = new Truck(fuelAmount, consumption, tankCapacity);
                break;
        }
        return vehicles;
    }
}
