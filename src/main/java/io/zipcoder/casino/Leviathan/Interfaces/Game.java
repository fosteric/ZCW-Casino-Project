package io.zipcoder.casino.Leviathan.Interfaces;
import io.zipcoder.casino.Leviathan.*;


public interface Game {
    Console aConsole = new Console();
 int playerScore = 0;
 int houseScore = 0;
 boolean winner = false;

    public void playGame();
}



