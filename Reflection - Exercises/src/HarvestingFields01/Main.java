package HarvestingFields01;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Class<RichSoilLand> method = RichSoilLand.class;

        String command = scanner.nextLine();
        while (!command.equals("HARVEST")) {
            if (command.equals("all")) {
                Arrays.stream(method.getDeclaredFields())
                        .forEach(e -> System.out.println(Modifier.toString(
                                e.getModifiers()) + " " + e.getType().getSimpleName() + " " + e.getName()));
            } else {
                String accessModifier = command;
                Arrays.stream(method.getDeclaredFields())
                        .filter(field -> Modifier.toString(field.getModifiers()).equals(accessModifier))
                        .forEach(field ->
                                System.out.println(Modifier.toString(field.getModifiers())
                                        + " " + field.getType().getSimpleName() + " " + field.getName()));
            }
            command = scanner.nextLine();
        }

    }
}
