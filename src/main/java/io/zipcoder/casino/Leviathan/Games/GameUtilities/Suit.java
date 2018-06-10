package io.zipcoder.casino.Leviathan.Games.GameUtilities;

public enum Suit {
    SPADES("\u2660"),
    HEARTS("\u2665"),
    DIAMONDS("\u2666"),
    CLUBS("\u2663");

    private String suitSymbol;
    private Suit(String suitSymbol) {
        this.suitSymbol=suitSymbol;
    }

    public String getsuitSymbol() {
        return this.suitSymbol;
    }

}


