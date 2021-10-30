package HotelReservation04;

public class PriceCalculator {

    public static double calculator(Reservation reservation) {
        double sum = reservation.getPricePerDay() * reservation.getNumberOfDays() * reservation.getSeason().getSeasons();
        return sum - sum * reservation.getDiscountType().getDiscount() / 100;
    }
}
