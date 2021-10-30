package StudentSystem03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StudentSystem studentSystem = new StudentSystem();

        while (true) {
            String[] input = scan.nextLine().split(" ");
            if (input[0].equals("Exit")) {
                break;
            }
            studentSystem.parseCommand(input);
        }
    }
}
