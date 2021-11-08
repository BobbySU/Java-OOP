package Animals06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        while (!input.equals("Beast!")) {
            String[] animal = scan.nextLine().split(" ");
            String name = animal[0];
            int age = Integer.parseInt(animal[1]);
            String gender = animal[2];
            try {
                switch (input) {
                    case "Cat":
                        Cat cat = new Cat(name, age, gender);
                        System.out.println(cat);
                        break;
                    case "Frog":
                        Frog frog = new Frog(name, age, gender);
                        System.out.println(frog);
                        break;
                    case "Dog":
                        Dog dog = new Dog(name, age, gender);
                        System.out.println(dog);
                        break;
                    case "Kitten":
                        Kitten kitten = new Kitten(name, age);
                        System.out.println(kitten);
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(name, age);
                        System.out.println(tomcat);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            input = scan.nextLine();
        }
    }
}
