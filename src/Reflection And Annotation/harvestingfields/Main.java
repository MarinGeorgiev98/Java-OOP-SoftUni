package harvestingfields;

import java.lang.reflect.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Class richClass = RichSoilLand.class;
        Field[] fields = richClass.getDeclaredFields();

        String command = scan.nextLine();

        while (!command.equals("HARVEST")) {
            for (Field field : fields) {
                String modifier = Modifier.toString(field.getModifiers());
                if (modifier.equals("protected")) {
                    String type = field.getType().getSimpleName();
                    String name = field.getName();
                    System.out.printf("%s %s %s %n", modifier, type, name);
                }
            }
            command = scan.nextLine();
        }
    }
}