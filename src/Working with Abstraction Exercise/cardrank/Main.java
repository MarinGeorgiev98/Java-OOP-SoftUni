package cardrank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();

        System.out.println("Card Ranks:");

        for (Cards card : Cards.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",
                    card.ordinal(), card.toString());
        }
    }
}