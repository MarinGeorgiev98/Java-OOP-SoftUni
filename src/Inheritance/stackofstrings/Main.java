package stackofstrings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StackOfStrings stackOfStrings = new StackOfStrings();
        stackOfStrings.push("1");
        stackOfStrings.push("2");
        stackOfStrings.push("3");

        System.out.println(stackOfStrings.pop());
        System.out.println(stackOfStrings.peek());
    }
}