package Reflection01;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        System.out.println("class " + clazz.getSimpleName());
        System.out.println(clazz.getSuperclass());
        try {
            Arrays.stream(clazz.getInterfaces())
                    .forEach(System.out::println);
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
