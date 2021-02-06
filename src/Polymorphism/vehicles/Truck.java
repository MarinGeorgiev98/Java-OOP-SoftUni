package vehicles;

public class Truck extends VehicleImpl {

    public static final double AIR_CONDITIONER_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double consumption) {
        super(fuelQuantity, consumption);
    }

    @Override
    public void drive(double distance) {
        System.out.print("Truck ");
        super.drive(distance);
    }

    @Override
    public String toString() {
        return "Truck " + super.toString();
    }
}