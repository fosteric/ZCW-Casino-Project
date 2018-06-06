package io.zipcoder.casino;

public class  HigherCards extends CardGame implements Gambling{

    public boolean playGame(Player aPlayer) {
        return false;
    }

    public int wageMoney() {
        return 0;
    }
}
