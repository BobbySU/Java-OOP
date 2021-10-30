package HotelReservation04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");
        double pricePerDay = Double.parseDouble(input[0]);
        int numberOfDays = Integer.parseInt(input[1]);
        String season = input[2];
        String discountType = input[3];

        Reservation reservation = new Reservation(pricePerDay, numberOfDays,
                Seasons.valueOf(season), Discount.valueOf(discountType));

        System.out.printf("%.2f",PriceCalculator.calculator(reservation));
    }
}
