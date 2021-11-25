package VehiclesExtension02;

public class Truck extends VehiclesImplements {

    private static final double CLIMATIC_CONSUMPTION = 1.6;
    private static final double REFILL_PERCENTAGE = 0.95;

    public Truck(Double fuelQuantity, Double litersPerKm, Double tankCapacity) {
        super(fuelQuantity, litersPerKm+CLIMATIC_CONSUMPTION, tankCapacity);
    }

    @Override
    public void refuel(Double liters) {
        super.refuel(liters * REFILL_PERCENTAGE);
    }
}
