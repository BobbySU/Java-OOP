package BorderControl05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Identifiable> passedBorder = new ArrayList<>();

        String input = scan.nextLine();
        while (!input.equals("End")) {

            String[] data = input.split("\\s+");
            Identifiable identifiable = data.length == 2
                    ? new Robot(data[0], data[1])
                    : new Citizen(data[0], Integer.parseInt(data[1]), data[2]);
            passedBorder.add(identifiable);
            input = scan.nextLine();
        }

        String fakeId = scan.nextLine();
        passedBorder.stream().filter(e -> e.getId().endsWith(fakeId)).forEach(e -> System.out.println(e.getId()));
    }
}
