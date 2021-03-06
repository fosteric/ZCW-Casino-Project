package io.zipcoder.casino.Leviathan.Games;

import io.zipcoder.casino.Leviathan.Console;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.Die;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.DrawSingleDie;
import io.zipcoder.casino.Leviathan.Interfaces.Gambling;
import io.zipcoder.casino.Leviathan.Player;


public class HigherDice extends DiceGame implements Gambling {
    private Console aConsole = new Console();
    private DrawSingleDie draw = new DrawSingleDie();
    private int bet;
    private Player aPlayer;
    private Die aDie = new Die();
    private boolean playAgain = true;

    public HigherDice(Player aPlayer) {
        this.aPlayer = aPlayer;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public boolean isPlayAgain() {
        return playAgain;
    }

    public void playGame() {
        aConsole.print("Welcome to HigherDice!\nWe will both roll a die, and the higher number wins the wager.\nThe House wins on ties\n");
        while (playAgain) {
            findWinner(wageMoney(), playerPhase(), housePhase());
            repeat();
        }
    }

    public void repeat() {
        if ((aPlayer.getTotalChips() == 0)) {
            aConsole.println("You are out of chips. You may no longer play\n");
            playAgain = false;
        } else if (aConsole.yesOrNo("Would you like to play again?").equalsIgnoreCase("no")) {
            playAgain = false;
        }
    }

    public void findWinner(int wageAmount, int player, int croupier) {

        if (player > croupier) {
            aPlayer.setTotalChips(aPlayer.getTotalChips() + wageAmount);
            int[] change = {aPlayer.getTally()[0] + 1, aPlayer.getTally()[1]};
            aPlayer.setTally(change);
            aConsole.println("You win! Your current chip total is: " + aPlayer.getTotalChips());
        } else {
            aPlayer.setTotalChips(aPlayer.getTotalChips() - wageAmount);
            int[] change = {aPlayer.getTally()[0], aPlayer.getTally()[1] + 1};
            aPlayer.setTally(change);
            aConsole.println("You lose! Your current chip total is: " + aPlayer.getTotalChips());
        }
        aConsole.println("Your current Win/Loss Ratio is " + aPlayer.getTally()[0] + "-" + aPlayer.getTally()[1] + "\n");
    }

    public int wageMoney() {
        do {
            bet = aConsole.getIntInput("How much would you like to bet? You can only bet what you currently have.\n" +
                    "Current chips= " + aPlayer.getTotalChips() + "\n");
        } while (badBet());
        return bet;
    }

    public boolean badBet() {
        return (bet > aPlayer.getTotalChips() || bet < 0);
    }

    private int playerPhase() {
        aConsole.getStringInput("Please roll your die");
        aDie.rollADice();
        aConsole.println("Your Roll:\n" + draw.drawSingleDie(aDie.getValue()).toString());
        return aDie.getValue();
    }

    private int housePhase() {
        aDie.rollADice();
        aConsole.println("House Roll:\n" + draw.drawSingleDie(aDie.getValue()).toString());
        return aDie.getValue();
    }
}
