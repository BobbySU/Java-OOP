package VehiclesExtension02;

public class Car extends VehiclesImplements {

    private static final double CLIMATIC_CONSUMPTION = 0.9;

    public Car(Double fuelQuantity, Double litersPerKm, Double tankCapacity) {
        super(fuelQuantity, litersPerKm+CLIMATIC_CONSUMPTION, tankCapacity);
    }
}
