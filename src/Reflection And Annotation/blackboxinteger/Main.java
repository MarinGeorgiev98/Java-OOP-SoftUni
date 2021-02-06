package blackboxinteger;

import java.lang.reflect.*;
import java.util.*;

public class Main {
    public static void main(String[] args)
            throws InvocationTargetException,
            IllegalAccessException,
            NoSuchFieldException {
        Scanner scan = new Scanner(System.in);

        Constructor<?>[] declaredConstructors =
                BlackBoxInt.class.getDeclaredConstructors();

        BlackBoxInt blackBoxInt = null;

        int index = 0;
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            if (declaredConstructor.getParameterCount() == 0) {
                System.out.printf("Found at: %d%n", index);
            }
            else {
                index++;
            }
        }

        String input = scan.nextLine();
        Method[] methods = BlackBoxInt.class.getDeclaredMethods();

        Field innerValue = BlackBoxInt.class.getDeclaredField("innerValue");
        while (!input.equals("END")) {
            String[] tokens = input.split("_");
            String name = tokens[0];
            int parameter = Integer.parseInt(tokens[1]);
            Method method = Arrays.stream(methods)
                    .filter(m -> m.getName().equals(name))
                    .findFirst().orElse(null);

            if (method != null) {
                method.setAccessible(true);
                method.invoke(blackBoxInt, parameter);
            }

            if (innerValue != null) {
                System.out.println(innerValue.get(blackBoxInt));
            }
            input = scan.nextLine();
        }
    }
}