package vehicles;

public class Bus extends VehicleImpl{

    private static final double AIR_CONDITIONER_CONSUMPTION = 1.4;
    private boolean occupied;

    public Bus(double fuelQuantity, double consumption) {
        super(fuelQuantity, consumption);
        this.occupied = false;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    @Override
    public void drive(double distance) {
        System.out.println("Bus: ");
        if (this.occupied) {
            super.addConsumption(AIR_CONDITIONER_CONSUMPTION);
        }
        super.drive(distance);
        if (this.occupied) {
            this.subtractConsumption(AIR_CONDITIONER_CONSUMPTION);
        }
        this.setOccupied(false);
    }
}