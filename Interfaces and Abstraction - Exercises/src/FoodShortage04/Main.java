package FoodShortage04;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, Person> personList = new TreeMap<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            if (input.length == 4) {
                //"{name} {age} {id} {birthdate}"
                Citizen citizen = new Citizen(input[0], Integer.parseInt(input[1]), input[2], input[3]);
                personList.putIfAbsent(input[0], citizen);
            } else {
                //"{name} {age}{group}"
                Rebel rebel = new Rebel(input[0], Integer.parseInt(input[1]), input[2]);
                personList.putIfAbsent(input[0], rebel);
            }
        }
        String buyerName = scan.nextLine();
        while (!buyerName.equals("End")) {
            if (personList.containsKey(buyerName)) {
                personList.get(buyerName).buyFood();
            }
            buyerName = scan.nextLine();
        }
        System.out.println(personList.values().stream().mapToInt(Person::getFood).sum());
    }
}
