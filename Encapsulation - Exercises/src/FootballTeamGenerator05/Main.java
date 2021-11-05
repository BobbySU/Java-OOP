package FootballTeamGenerator05;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Team> data = new LinkedHashMap<>();

        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] splitData = input.split(";");
            switch (splitData[0]) {
                case "Team":
                    try {
                        data.put(splitData[1], new Team(splitData[1]));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Add":
                    int endurance = Integer.parseInt(splitData[3]);
                    int sprint = Integer.parseInt(splitData[4]);
                    int dribble = Integer.parseInt(splitData[5]);
                    int passing = Integer.parseInt(splitData[6]);
                    int shooting = Integer.parseInt(splitData[7]);

                    if (data.containsKey(splitData[1])) {
                        try {
                            data.get(splitData[1]).addPlayer(new Player(splitData[2],
                                    endurance, sprint, dribble, passing, shooting));
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println(String.format("Team %s does not exist.", splitData[1]));
                    }
                    break;
                case "Remove":
                    try {
                        data.get(splitData[1]).removePlayer(splitData[2]);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Rating":
                    if (data.containsKey(splitData[1])) {
                        double rating = Math.round(data.get(splitData[1]).getRating());
                        System.out.println(String.format("%s - %.0f", splitData[1], rating));
                    } else {
                        System.out.println(String.format("Team %s does not exist.", splitData[1]));
                    }
                    break;
            }
            input = scan.nextLine();
        }
    }
}

