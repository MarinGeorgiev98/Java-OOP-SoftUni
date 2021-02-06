package bordercontrol;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> ids = new ArrayList<>();

        String input = scan.nextLine();

        while(!input.equals("END")) {
            String[] tokens = input.split(" ");
            if (tokens.length == 3) {
                String id = tokens[2];
               ids.add(id);
            }
            else {
                String id = tokens[1];
                ids.add(id);
            }
            input = scan.nextLine();
        }

        String lastDigits = scan.nextLine();

        ids
                .stream()
                .filter(s -> s.endsWith(lastDigits))
                .forEach(System.out::println);
    }
}