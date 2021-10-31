package CardsWithPower03;

public class Card {
    String rank;
    String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    private int getPower() {
        return Rank.valueOf(this.rank).getRank() + Suit.valueOf(this.suit).getSuit();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", this.rank, this.suit, getPower());
    }
}
