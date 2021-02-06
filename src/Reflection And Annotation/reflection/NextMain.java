package reflection;

import java.lang.reflect.Method;
import java.util.*;

public class NextMain {
    public static void main(String[] args) {

        Class reflectionClass = Reflection.class;
        Method[] allMethods = reflectionClass.getDeclaredMethods();
        List<Method> getters = new ArrayList<>();
        List<Method> setters = new ArrayList<>();
        for (Method method : allMethods) {
            if(isSetter(method)) {
                setters.add(method);
            }
            else if (isGetter(method)){
                getters.add(method);
            }
        }

        setters.sort((f, s) -> f.getName().compareTo(s.getName()));
        getters.sort((f, s) -> f.getName().compareTo(s.getName()));
        setters.forEach(System.out::println);
        getters.forEach(System.out::println);
    }

    private static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get")) {
            return false;
        }
        if (method.getReturnType() == void.class) {
            return false;
        }
        if (method.getParameterCount() != 0) {
            return false;
        }
        return true;
    }

    private static boolean isSetter(Method method) {
        if (!method.getName().startsWith("set")) {
            return false;
        }
       if(method.getReturnType() != void.class) {
            return false;
        }
        if (method.getParameterCount() != 1) {
            return false;
        }
        return true;
    }
}