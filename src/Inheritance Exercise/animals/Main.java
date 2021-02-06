package animals;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        List<Animal> animals = new ArrayList<>();

        while(!command.equals("Beast!")) {
            String[] arr = scan.nextLine().split(" ");
            String name = arr[0];
            int age = Integer.parseInt(arr[1]);
            String gender = arr[2];
            Animal animal;
            try {
                if (command.equals("Dog")) {
                    animal = new Dog(name, age, gender);
                }
                else if (command.equals("Cat")) {
                    animal = new Cat(name, age, gender);

                }
                else if (command.equals("Frog")) {
                    animal = new Frog(name, age, gender);

                }
                else if (command.equals("Kitten")) {
                    animal = new Kitten(name, age);
                }
                else {
                    animal = new Tomcat(name, age);
                }
                animals.add(animal);
            }
            catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            command = scan.nextLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}