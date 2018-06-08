package io.zipcoder.casino;

public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }


    public Rank getRank() {
        return rank;
    }


}
