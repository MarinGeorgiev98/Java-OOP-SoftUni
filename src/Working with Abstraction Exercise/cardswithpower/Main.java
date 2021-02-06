package cardswithpower;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String rank = scan.nextLine();
        String suit = scan.nextLine();
        RankPower rankPower = RankPower.valueOf(rank);
        SuitPower suitPower = SuitPower.valueOf(suit);

        System.out.printf("Card name: %s of %s; Card power: %d%n",
                rankPower.toString(), suitPower.toString(),
                rankPower.getValue() + suitPower.getValue());
    }
}