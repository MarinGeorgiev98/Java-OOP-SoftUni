package randomarraylist;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        RandomArrayList<Integer> randomArrayList = new RandomArrayList<>();
        randomArrayList.add(5);
        randomArrayList.add(6);
        randomArrayList.add(7);
        randomArrayList.add(8);
        System.out.println(randomArrayList.getRandomElement());
    }
}