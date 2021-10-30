package HotelReservation04;

public enum  Seasons {
    Autumn(1),
    Spring(2),
    Winter(3),
    Summer(4);

    private int seasons;

    Seasons(int seasons) {
        this.seasons = seasons;
    }

    public int getSeasons() {
        return seasons;
    }
}
