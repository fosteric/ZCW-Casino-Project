package io.zipcoder.casino;

public interface Game {
    Console aConsole = new Console();
 int playerScore = 0;
 int houseScore = 0;
 boolean winner = false;

    public boolean playGame();
}



