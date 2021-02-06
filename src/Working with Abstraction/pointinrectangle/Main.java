package pointinrectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] input = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Rectangle rectangle = new Rectangle(input[0], input[1], input[2], input[3]);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int x = arr[0];
            int y = arr[1];
            System.out.println(rectangle.contains(new Point(x, y)));
        }
    }
}