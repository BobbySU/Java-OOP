package VehiclesExtension02;

import java.text.DecimalFormat;

public class Bus extends VehiclesImplements {

    private static final double CLIMATIC_CONSUMPTION = 1.4;

    public Bus(Double fuelQuantity, Double litersPerKm, Double tankCapacity) {
        super(fuelQuantity, litersPerKm + CLIMATIC_CONSUMPTION, tankCapacity);
    }

    public String driveEmpty(double km) {
        DecimalFormat format = new DecimalFormat("#.##");
        double emptyConsumption = super.getLitersPerKm() - CLIMATIC_CONSUMPTION;
        if (emptyConsumption * km <= super.getFuelQuantity()) {
            super.setFuelQuantity(super.getFuelQuantity() - (emptyConsumption * km));
            return String.format("%s travelled %s km", this.getClass().getSimpleName(), format.format(km));
        }
        return String.format("%s needs refueling", this.getClass().getSimpleName());
    }
}
