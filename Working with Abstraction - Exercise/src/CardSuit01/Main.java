package CardSuit01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Card Suits:");

        for (Cards e : Cards.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",e.ordinal(),e);
        }
    }
}
