package hotelreservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double pricePerDay = Double.parseDouble(scan.next());
        int numberOfDays = scan.nextInt();
        String seasonName = scan.next();
        String discountType = scan.next();

        Season season = Season.valueOf(seasonName);
        Discount discount = Discount.valueOf(discountType);

        double totalPrice = getPriceFor(pricePerDay, numberOfDays,
                season, discount);
        System.out.printf("%.2f%n", totalPrice);
    }

    private static double getPriceFor(double pricePerDay,
                                      int numberOfDays,
                                      Season season,
                                      Discount discount) {
        return pricePerDay * season.getSeasonIndex() *
                numberOfDays * discount.getDiscount();
    }
}