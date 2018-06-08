package io.zipcoder.casino.Leviathan.Games.GameUtilities;

public class Card {

    private Rank rank;
    private Suit suit;


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


    public static void main(String[] args) {
    }
//        Card ten = new Card(Rank.TEN, Suit.SPADES);
//        Card one = new Card(Rank.ACE, Suit.SPADES);
//
//        Rank rank = ten.getRank();
//        System.out.println(rank);
//
//
//        String yourCard = one.getRank() + " of " + one.getSuit();
//        System.out.println(yourCard);
//        System.out.println(ten.getRank());
//        System.out.println(one.getRank());
//    }


}
