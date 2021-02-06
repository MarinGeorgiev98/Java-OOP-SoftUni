package shoppingspree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Person> people = new HashMap<>();
        Map<String, Product> products = new HashMap<>();
        String[] input = scan.nextLine().split(";");
        for (int i = 0; i < input.length; i++) {
            String[] peopleArr = input[i].split("=");
            String name = peopleArr[0];
            double money = Double.parseDouble(peopleArr[1]);
            Person person = new Person(name, money);
            people.put(name, person);
        }
        String[] nextInput = scan.nextLine().split(";");
        for (int i = 0; i < nextInput.length; i++) {
            String[] productsArr = nextInput[i].split("=");
            String name = productsArr[0];
            double cost = Double.parseDouble(productsArr[1]);
            Product product = new Product(name, cost);
            products.put(name, product);
        }
        String command = scan.nextLine();
        while (!command.equals("END")) {
            String[] arr = command.split(" ");
            String personName = arr[0];
            String productName = arr[1];
            people.get(personName).buyProduct(products.get(productName));
            command = scan.nextLine();
        }
        for (Person person : people.values()) {
            if (person.getProducts().isEmpty()) {
                System.out.printf("%s – Nothing bought%n", person.getName());
            }
            else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < person.getProducts().size(); i++) {
                    sb.append(person.getProducts().get(i).getName());
                    if (i == person.getProducts().size() - 1) {
                        break;
                    }
                    sb.append(", ");
                }
                System.out.printf("%s - %s%n", person.getName(), sb);
            }
        }
    }
}