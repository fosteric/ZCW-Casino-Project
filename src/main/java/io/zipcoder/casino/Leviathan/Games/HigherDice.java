package io.zipcoder.casino.Leviathan.Games;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.Die;
import io.zipcoder.casino.Leviathan.Interfaces.*;
import io.zipcoder.casino.Leviathan.*;


public class HigherDice extends DiceGame implements Gambling {
    Console aConsole = new Console();
    int bet;
    Player aPlayer;
    Die aDie = new Die();
    boolean playAgain = true;

    public HigherDice(Player aPlayer) {
        this.aPlayer = aPlayer;
    }


    public void playGame() {
        aConsole.print("Welcome to HigherDice!\nWe will both roll a die, and the higher number wins the wager.\nThe House wins on ties\n");

        while(playAgain == true){

        bet = wageMoney();
        aConsole.getStringInput("Please roll your die");
        aDie.rollADice();
        int player = aDie.getValue();
        aConsole.println("You rolled a " + player);
        aDie.rollADice();
        int croupier = aDie.getValue();
        aConsole.println("The House rolled a " + croupier);
        findWinner(player, croupier, bet);


        if((aPlayer.getTotalChips() == 0) || aConsole.getStringInput("Would you like to play again?").equalsIgnoreCase("no")){
            playAgain= false;
        }
        }
    }

    public int findWinner(int player, int croupier, int wageAmount) {

        if (player > croupier) {

            aPlayer.setTotalChips(aPlayer.getTotalChips() + wageAmount);
            aConsole.println("You win! Your current chip total is: "+ aPlayer.getTotalChips());

        } else {

            aPlayer.setTotalChips(aPlayer.getTotalChips() - wageAmount);
            aConsole.println("You lose! Your current chip total is: "+ aPlayer.getTotalChips());
        }

        return aPlayer.getTotalChips();
    }

    public int wageMoney() {

        do {
            bet = aConsole.getIntInput("How much would you like to bet? You can only bet what you currently have.\n" +
                    "Current chips= " + aPlayer.getTotalChips()+ "\n");

        }while(bet > aPlayer.getTotalChips());

        return bet;
    }
}
