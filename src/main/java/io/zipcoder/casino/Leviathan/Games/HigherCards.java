package io.zipcoder.casino.Leviathan.Games;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.*;

import io.zipcoder.casino.Leviathan.Interfaces.*;
import io.zipcoder.casino.Leviathan.*;

public class  HigherCards extends CardGame implements Gambling{
    Console aConsole=new Console();
    Player aPlayer;
    boolean playAgain = true;
    Deck deck = new Deck();
    int wageAmount;

    int player,croupier;

    public HigherCards(Player aPlayer){
        this.aPlayer = aPlayer;
    }

     public void playGame() {
         aConsole.print("Welcome to HigherCards!\nWe both will draw a card, and the higher card wins the wager.\nThe House wins on ties\n");
         while (playAgain) {
             deck.shuffle();
             int wageAmount = wageMoney();
             playerDrawingCard();
             houseDrawingCard();
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
             repeat();
         }
     }
     public void repeat()
     {
         if((aPlayer.getTotalChips() == 0) )
         {
             aConsole.println("You are out of chips. You may no longer play\n");
             playAgain= false;
         }
         else if(aConsole.yesOrNo("Would you like to play again?").equalsIgnoreCase("no"))
         {
             playAgain = false;
         }
     }
     public void playerDrawingCard()
     {

         Card acard = deck.draw();

         Rank rank = acard.getRank();
         player = rank.getValue();
         String playervalueString=rank.toString();
         String playerFace=rank.getFaceValue();

         Suit suit = acard.getSuit();
         String suitSymbol=suit.getsuitSymbol();
         String suitString = suit.toString();

         aConsole.println("You got :%s of %s",playervalueString,suitString);
         printCard(suitSymbol,playerFace);

     }
     public void houseDrawingCard()
     {
         Card acard2 = deck.draw();
         Rank rank2 = acard2.getRank();
         croupier = rank2.getValue();
         String playervalueString2=rank2.toString();
         String playerFace2=rank2.getFaceValue();

         Suit suit2 = acard2.getSuit();
         String suitString2 = suit2.toString();
         String suitSymbol2=suit2.getsuitSymbol();

         aConsole.println("House got :%s of %s",playervalueString2,suitString2);
         printCard(suitSymbol2,playerFace2);

     }


    public void findWinner(int player,int croupier,int wageAmount)
    {
        if (player > croupier) {
            int[] change = {aPlayer.getTally()[0] + 1, aPlayer.getTally()[1]};
            aPlayer.setTally(change);
           aPlayer.setTotalChips(aPlayer.getTotalChips()+ wageAmount);
            aConsole.println("Your current Win/Loss Ratio is " + aPlayer.getTally()[0] + "-" + aPlayer.getTally()[1] + "\n");
        }
        else {
            int[] change = {aPlayer.getTally()[0], aPlayer.getTally()[1] + 1};
            aPlayer.setTally(change);
            aPlayer.setTotalChips(aPlayer.getTotalChips()- wageAmount);
            aConsole.println("Your current Win/Loss Ratio is " + aPlayer.getTally()[0] + "-" + aPlayer.getTally()[1] + "\n");
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

