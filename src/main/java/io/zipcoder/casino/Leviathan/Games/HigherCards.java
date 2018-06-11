package io.zipcoder.casino.Leviathan.Games;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.*;

import io.zipcoder.casino.Leviathan.Interfaces.*;
import io.zipcoder.casino.Leviathan.*;

public class  HigherCards extends CardGame implements Gambling{

    Console aConsole=new Console();
    Deck deck = new Deck();
    Player aPlayer;
    boolean playAgain = true;
    int bet;
    int player,croupier;
    int totalChips,wageAmount;
    public void setBet(int bet) {
        this.bet = bet;
    }

    public HigherCards(Player aPlayer){
        this.aPlayer = aPlayer;
    }
    public void playGame() {
         aConsole.print("Welcome to HigherCards!\nWe both will draw a card, and the higher card wins the wager.\nThe House wins on ties\n");
         while (playAgain) {
             deck.shuffle();
             int wageAmount = wageMoney();
             aConsole.println("You Got :");
             playerDrawingCard();
             aConsole.println("House Got :");
             houseDrawingCard();
             findWinner(wageAmount,player, croupier);
             aConsole.println("Your current available Chips %d",aPlayer.getTotalChips());
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
         Suit suit = acard.getSuit();
         printCard(suit.getsuitSymbol(),rank.getFaceValue());
     }
     public void houseDrawingCard()
     {
         Card acard2 = deck.draw();
         Rank rank2 = acard2.getRank();
         croupier = rank2.getValue();
         Suit suit2 = acard2.getSuit();
         printCard(suit2.getsuitSymbol(),rank2.getFaceValue());
     }

    public void findWinner(int wageAmount,int player,int croupier)
    {
        if (player > croupier) {
            aConsole.println("Congrats ! You Won ");
            int[] change = {aPlayer.getTally()[0] + 1, aPlayer.getTally()[1]};
            aPlayer.setTally(change);
           aPlayer.setTotalChips(aPlayer.getTotalChips()+ wageAmount);
        }
        else {
            aConsole.println("You Lose");
            int[] change = {aPlayer.getTally()[0], aPlayer.getTally()[1] + 1};
            aPlayer.setTally(change);
            aPlayer.setTotalChips(aPlayer.getTotalChips()- wageAmount);
        }

        aConsole.println("Your current Win/Loss Ratio is " + aPlayer.getTally()[0] + "-" + aPlayer.getTally()[1] + "\n");
    }

    public int wageMoney() {
        do {
            bet = aConsole.getIntInput("How much would you like to bet? You can only bet what you currently have.\n" +
                    "Current chips= " + aPlayer.getTotalChips());

        }while (badBet());
        return bet;
    }

    public boolean badBet(){
        return (bet > aPlayer.getTotalChips() || bet < 0);
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

