package TrafficLights04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Color[] input = Arrays.stream(scan.nextLine().split(" "))
                .map(Color::valueOf).toArray(Color[]::new);
        int n = Integer.parseInt(scan.nextLine());

        List<TrafficLights> trafficLights = new ArrayList<>();
        for (Color e : input) {
            TrafficLights trafficLight = new TrafficLights(e);
            trafficLights.add(trafficLight);
        }

        for (int i = 0; i < n; i++) {
            for (TrafficLights t : trafficLights) {
                t.ChangeColor();
                System.out.print(t.toString() + " ");
            }
            System.out.println();
        }
    }
}
