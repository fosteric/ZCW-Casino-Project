package io.zipcoder.casino.Leviathan.Games;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.Deck;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.Rank;

import io.zipcoder.casino.Leviathan.Games.GameUtilities.Card;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.Suit;
import io.zipcoder.casino.Leviathan.Interfaces.*;
import io.zipcoder.casino.Leviathan.*;

public class  HigherCards extends CardGame implements Gambling{
    Console aConsole=new Console();
    Player aPlayer;
    boolean playAgain = true;

    public HigherCards(Player aPlayer){
        this.aPlayer = aPlayer;
    }

     public void playGame() {
         aConsole.print("Welcome to HigherCards!\nWe both will draw a card, and the higher card wins the wager.\nThe House wins on ties\n");
         while (playAgain) {
             /*aConsole.println("\u2660");//spades
             aConsole.println("\u2665");//heart
             aConsole.println("\u2666");//diamond
             aConsole.println("\u2663");//suit
             String heart="\u2660";
             int k=6;
             aConsole.println(heart);*/
             int wageAmount = wageMoney();

             Deck deck = new Deck();

             Card acard = deck.draw();
             Rank rank = acard.getRank();
             int player = rank.getValue();
             String playervalueString=rank.toString();
             String playerFace=rank.getFaceValue();

             Suit suit = acard.getSuit();
             String suitSymbol=suit.getsuitSymbol();
             String suitString = suit.toString();

             aConsole.println("You got :%s of %s",playervalueString,suitString);
             /*aConsole.println("Your suit is :");
             aConsole.print(suitString);
             aConsole.println("\nYour rank is :");
             String rankValue = rank.toString();
             aConsole.println(rankValue);*/
             printCard(suitSymbol,playerFace);

             Card acard2 = deck.draw();
             Rank rank2 = acard2.getRank();
             int croupier = rank2.getValue();
             String playervalueString2=rank2.toString();
             String playerFace2=rank2.getFaceValue();

             Suit suit2 = acard2.getSuit();
             String suitString2 = suit2.toString();
             String suitSymbol2=suit2.getsuitSymbol();
             aConsole.println("House got :%s of %s",playervalueString2,suitString2);
             /*aConsole.println("\n\nHouse suit is :");
             aConsole.print(suitString2);
             aConsole.println("\nHouse rank is :");
             String rankValue2 = rank2.toString();
             aConsole.println(rankValue2);*/
             printCard(suitSymbol2,playerFace2);

             int totalChips = aPlayer.getTotalChips();
             findWinner(player, croupier, wageAmount);
             if (aPlayer.getTotalChips() > totalChips) {
                 aConsole.println("Congrats ! You Won ");
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
    public void findWinner(int player,int croupier,int wageAmount)
    {

        if (player > croupier) {

           aPlayer.setTotalChips(aPlayer.getTotalChips()+ wageAmount);
        }
        else {

            aPlayer.setTotalChips(aPlayer.getTotalChips()- wageAmount);
        }


    }


    public int wageMoney() {
        int bet;

        do {
            bet = aConsole.getIntInput("How much would you like to bet? You can only bet what you currently have.\n" +
                    "Current chips= " + aPlayer.getTotalChips());

        }while(bet > aPlayer.getTotalChips());

        return bet;
    }

    public void printCard(String suitSymbol,String playerFace)
    {
        aConsole.println(" ---------");
        aConsole.println("| %s     %s |",playerFace,suitSymbol);
        for(int i=0;i<5;i++)
        {
            aConsole.println("|         |");
        }
        aConsole.println("| %s     %s |",suitSymbol,playerFace);
        aConsole.println(" ---------");
    }


}

