package CardsWithPower03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String rang = scan.nextLine();
        String suit = scan.nextLine();
        Card card = new Card(rang, suit);

        System.out.println(card.toString());
    }
}
