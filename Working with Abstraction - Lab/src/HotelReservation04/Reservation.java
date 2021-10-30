package HotelReservation04;

public class Reservation {
    private double pricePerDay;
    private int numberOfDays;
    private Seasons season;
    private Discount discountType;

    public Reservation(double pricePerDay, int numberOfDays, Seasons season, Discount discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discountType = discountType;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public Seasons getSeason() {
        return season;
    }

    public Discount getDiscountType() {
        return discountType;
    }
}
