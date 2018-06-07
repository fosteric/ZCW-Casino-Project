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




 /*   int n = Suit * Rank;
    String[] deck = new String[n];
        for (int i = 0; i < Rank.length; i++) {
        for (int j = 0; j < SUITS.length; j++) {
            deck[SUITS.length*i + j] = RANKS[i] + " of " + SUITS[j];
        }
    }*/


//    Suit aSuit;
//    Rank aRank;
//
//    public void setSuit(){
//    }
//
//    public static Suit getSuit(){
//       return Suit.SPADES;
//
//    }
//
//    public void setRank(){
//    }
//
//    public static Rank getRank(){
//        return Rank.ACE;
//    }
//
//    public Card(int Suit, int Rank) {
//        this.aSuit = aSuit;
//        this.aRank = aRank;
//    }


