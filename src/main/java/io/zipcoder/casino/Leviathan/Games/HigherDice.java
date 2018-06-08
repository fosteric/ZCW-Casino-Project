package io.zipcoder.casino.Leviathan.Games;
import io.zipcoder.casino.Leviathan.Interfaces.*;
import io.zipcoder.casino.Leviathan.*;

public class HigherDice extends DiceGame implements Gambling {
    Console aConsole = new Console();
    int bet;
    int totalChips;
    Player aPlayer;

    public HigherDice(Player aPlayer) {
        this.aPlayer = aPlayer;
    }

    public boolean playGame() {

        Boolean result;
        bet = wageMoney();
        int player = 0;
        int croupier = 0;

        /*

        Rank.

        */
        totalChips = aPlayer.getTotalChips();
        int newTotalChips = findWinner(player, croupier, bet, totalChips);
        aPlayer.setTotalChips(newTotalChips);
        if (newTotalChips > totalChips) {
            result = true;
        } else {
            result = false;
        }
        return result;

    }

    public int findWinner(int player, int croupier, int wageAmount, int totalChips) {

        if (player > croupier) {

            totalChips = totalChips + wageAmount;

        } else {

            totalChips = totalChips - wageAmount;
        }

        return totalChips;
    }


    public int wageMoney() {
        int bet;

        do {
            bet = aConsole.getIntInput("How much would you like to bet? You can only bet what you currently have.\n" +
                    "Current chips= " + aPlayer.getTotalChips());

        }while(bet > aPlayer.getTotalChips());

        return bet;
    }
}
