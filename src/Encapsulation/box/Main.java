package box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            Box box = new Box(2, 3, 4);
            System.out.printf("Surface Area - %.2f%n", box.calculateSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f%n",
                    box.calculateLateralSurfaceArea());
            System.out.printf("Volume - %.2f%n", box.calculateVolume());
        }
        catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}