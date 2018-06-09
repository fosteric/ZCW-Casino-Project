package io.zipcoder.casino.Leviathan.Games.GameUtilities;

public class Die {
    int value;

    public void setValue() {
    }

    public int getValue() {
        return value;

    }

    public void rollADice() {
        int rolled = (int) (Math.random() * 6) + 1;
        value = rolled;
    }

}
