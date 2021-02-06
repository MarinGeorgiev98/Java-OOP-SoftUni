package cardsuit;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();

        System.out.println("Card suits:");

        for (Card card : Card.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s",
                    card.ordinal(), card.toString());
        }
    }
}