package io.zipcoder.casino.Leviathan.Games;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.Deck;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.Rank;

import io.zipcoder.casino.Leviathan.Games.GameUtilities.Card;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.Suit;
import io.zipcoder.casino.Leviathan.Interfaces.*;
import io.zipcoder.casino.Leviathan.*;

public class  HigherCards extends CardGame implements Gambling{
    Console aConsole=new Console();
    int wageAmount;
    int totalChips;
    Player aPlayer;
    boolean playAgain = true;

    public HigherCards(Player aPlayer){
        this.aPlayer = aPlayer;
    }

     public void playGame() {

         Boolean result;
         while (playAgain == true) {
             int wageAmount = wageMoney();

             Deck deck = new Deck();

             Card acard = deck.draw();
             Rank rank = acard.getRank();
             int player = rank.getValue();
             Suit suit = acard.getSuit();
             String suitString = suit.toString();

             aConsole.println("Your suit is :");
             aConsole.print(suitString);
             aConsole.println("\nYour rank is :");
             String rankValue = rank.toString();
             aConsole.println(rankValue);

             Card acard2 = deck.draw();
             Rank rank2 = acard2.getRank();
             Suit suit2 = acard2.getSuit();
             String suitString2 = suit2.toString();
             int croupier = rank2.getValue();
             aConsole.println("\n\nHouse suit is :");
             aConsole.print(suitString2);
             aConsole.println("\nHouse rank is :");
             String rankValue2 = rank2.toString();
             aConsole.println(rankValue2);

             int totalChips = aPlayer.getTotalChips();
             int newTotalChips = findWinner(player, croupier, wageAmount, totalChips);
             if (newTotalChips > totalChips) {
                 aConsole.println("Congrats ! You Won");
                 aConsole.println("Your current available Chips");
                 String availableChips = aPlayer.getTotalChips().toString();
                 aConsole.println(availableChips);
             } else {
                 aConsole.println("You Lose");
                 aConsole.println("Your current available Chips");
                 String availableChips = aPlayer.getTotalChips().toString();
                 aConsole.println(availableChips);

             }
             if((aPlayer.getTotalChips() == 0) || aConsole.getStringInput("Would you like to play again?").equalsIgnoreCase("no")){
                 playAgain= false;

             }


         }
     }
    public int findWinner(int player,int croupier,int wageAmount,int totalChips)
    {

        if (player > croupier) {

           totalChips = totalChips+ wageAmount;
        }
        else {

            totalChips = totalChips-wageAmount;
        }
        aPlayer.setTotalChips(totalChips);
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

