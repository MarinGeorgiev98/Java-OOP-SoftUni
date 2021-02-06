import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= n; i++) {
            printRow(n, i);
        }
        for (int i = n - 1; i >= 1 ; i--) {
            printRow(n, i);
        }
    }

    private static void printRow(int n, int i) {
        for (int j = 0; j < n - i; j++) {
            System.out.print(" ");
        }
        for (int j = 1; j < i; j++) {
            System.out.print("* ");
        }
        System.out.println("*");
    }
}