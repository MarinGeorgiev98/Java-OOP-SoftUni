package needforspeed;

public class Vehicle {
    public static final double DEFAULT_FUEL_CONSUMPTION = 1.25;
    public double fuelConsumption;
    double fuel;
    int horsePower;

    public Vehicle (double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        this.fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
    }

    public static double getDefaultFuelConsumption() {
        return DEFAULT_FUEL_CONSUMPTION;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void drive(int kilometers) {
        if (canDrive(kilometers)) {
            this.fuel -= this.fuelConsumption * kilometers;
        }
    }

    private boolean canDrive(int kilometers) {
        return this.fuel >= this.fuelConsumption * kilometers;
    }
}