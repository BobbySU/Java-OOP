package Reflection01;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;

        System.out.println("class " + clazz.getSimpleName());
        System.out.println("class java.lang." + clazz.getSuperclass().getSimpleName());
        try {
            Arrays.stream(clazz.getInterfaces())
                    .map(Class::getSimpleName)
                    .forEach(e -> System.out.println("interface java.io." + e));
            Constructor<Reflection> declaredConstructor = clazz.getDeclaredConstructor();
            Reflection reflection = declaredConstructor.newInstance();
            System.out.println(reflection);
        } catch (InstantiationException
                | InvocationTargetException
                | NoSuchMethodException
                | IllegalAccessException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
