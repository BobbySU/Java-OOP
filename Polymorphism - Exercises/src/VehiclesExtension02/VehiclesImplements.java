package VehiclesExtension02;

import java.text.DecimalFormat;

public abstract class VehiclesImplements implements Vehicles {
    private Double fuelQuantity;
    private Double litersPerKm;
    private Double tankCapacity;

    public VehiclesImplements(Double fuelQuantity, Double litersPerKm, Double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKm = litersPerKm;
        this.tankCapacity = tankCapacity;
    }

    public Double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(Double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public Double getLitersPerKm() {
        return litersPerKm;
    }

    public void setLitersPerKm(Double litersPerKm) {
        this.litersPerKm = litersPerKm;
    }

    @Override
    public String drive(Double distance) {
        Double fuelNeeded = distance * this.getLitersPerKm();
        if (fuelNeeded > this.fuelQuantity) {
            return this.getClass().getSimpleName() + " needs refueling";
        }
        this.fuelQuantity -= fuelNeeded;

        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), formatter.format(distance));
    }

    @Override
    public void refuel(Double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        double newLiters = this.fuelQuantity + liters;
        if (newLiters > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
