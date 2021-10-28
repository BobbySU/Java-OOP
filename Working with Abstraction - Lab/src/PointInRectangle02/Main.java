package PointInRectangle02;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] input = readArrays(scan);

        Point pointA = new Point(input[0], input[1]);
        Point pointC = new Point(input[2], input[3]);

        Rectangle rectangle = new Rectangle(pointA, pointC);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            int[] checkPoint = readArrays(scan);

            System.out.println(rectangle.contains(new Point(checkPoint[0], checkPoint[1])));
        }
    }

    private static int[] readArrays(Scanner scan) {
        return Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
