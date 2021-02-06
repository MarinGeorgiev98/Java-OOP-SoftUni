package vehicles;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {
    private static final DecimalFormat formatter = new DecimalFormat("#.##");
    private double fuelQuantity;
    private double consumption;

    public VehicleImpl(double fuelQuantity, double consumption) {
        this.fuelQuantity = fuelQuantity;
        this.consumption = consumption;
    }

    @Override
    public void drive(double distance) {
        if (canDrive(distance)) {
            this.fuelQuantity -= this.consumption * distance;
            System.out.println(String.format("travelled %s km",
                    formatter.format(distance)));
        }
        else {
            System.out.println("Car/Truck needs refueling");
        }
    }

    @Override
    public void refuel(double liters) {
        if (liters < 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity += liters;
    }

    private boolean canDrive(double distance) {
        return distance * this.consumption <= this.fuelQuantity;
    }

    @Override
    public String toString() {
        return String.format("%.2f", this.fuelQuantity);
    }

    public void addConsumption(double additionalConsumption) {
        this.consumption += additionalConsumption;
    }

    public void subtractConsumption(double additionalConsumption) {
        this.consumption -= additionalConsumption;
    }
}