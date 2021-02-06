package vehicles;

public class Car extends VehicleImpl {

    public static final double AIR_CONDITIONER_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double consumption) {
        super(fuelQuantity, consumption + AIR_CONDITIONER_CONSUMPTION);
    }

    @Override
    public void drive(double distance) {
        System.out.print("Car ");
        super.drive(distance);
    }

    @Override
    public void refuel(double liters) {
        double newLiters = liters * 0.9;
        super.refuel(newLiters);
    }

    @Override
    public String toString() {
        return "Car " + super.toString();
    }
}