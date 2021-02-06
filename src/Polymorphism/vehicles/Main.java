package vehicles;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Vehicle> vehicles = new HashMap<>();
        vehicles.put("Car", readVehicleInput(scan.nextLine()));
        vehicles.put("Truck", readVehicleInput(scan.nextLine()));
        vehicles.put("Bus", readVehicleInput(scan.nextLine()));

        int n = Integer.parseInt(scan.nextLine());

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split(" ");
            String command = tokens[0];
            String type = tokens[1];
            double value = Double.parseDouble(tokens[2]);
            if (command.equals("Drive") && !type.equals("Bus")) {
                vehicles.get(type).drive(value);
            } else if (command.equals("Drive")) {
                ((Bus) vehicles.get(type)).setOccupied(true);
                vehicles.get(type).drive(value);
            }
            else {
                vehicles.get(type).refuel(value);
            }
        }
        vehicles.values().forEach(System.out::println);
    }

    private static Vehicle readVehicleInput(String nextLine) {
        String[] tokens = nextLine.split(" ");
        return tokens[0].equals("Car")
                ? new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]))
                : new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
    }
}