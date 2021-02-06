package reflection;

import java.lang.reflect.*;
import java.util.*;

public class Main {
    public static void main(String[] args)
            throws NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {
        Scanner scan = new Scanner(System.in);

        Class reflectionClass = Reflection.class;

        Arrays
                .stream(reflectionClass.getDeclaredFields())
                .filter(f -> Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(e -> System.out.println(e.getName() + "must be private!"));
        System.out.println(reflectionClass.getName());
        System.out.println(reflectionClass.getSuperclass());

        Class[] interfaces = reflectionClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface.getName());
        }

        Object o = reflectionClass.getDeclaredConstructor().newInstance();

        System.out.println(o);
    }
}