package BlackBoxInteger02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);
        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        Field innerValue = clazz.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        String[] command = scanner.nextLine().split("_");
        while (!command[0].equals("END")) {
            Method method = clazz.getDeclaredMethod(command[0], int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, Integer.parseInt(command[1]));
            System.out.println(innerValue.get(blackBoxInt));
            command = scanner.nextLine().split("_");
        }
    }
}
