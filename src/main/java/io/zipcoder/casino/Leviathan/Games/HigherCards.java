package io.zipcoder.casino.Leviathan.Games;
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

    public HigherCards(Player aPlayer){
        this.aPlayer = aPlayer;
    }

     public boolean playGame() {

        Boolean result;
        wageAmount=wageMoney();
        int player1=10;
        int croupier1=2;

        Card acard = new Card(Rank.TEN,Suit.SPADES);
        Rank rank=acard.getRank();
        Suit suit=acard.getSuit();
        String suitString=suit.toString();
        int player=rank.getValue();
         aConsole.println("Your suit is :");
         aConsole.print(suitString);
         aConsole.println("\nYour rank is :");
         String rankValue=rank.toString();
         aConsole.println(rankValue);

         Card acard2 = new Card(Rank.TEN,Suit.SPADES);
        Rank rank2=acard2.getRank();
        Suit suit2=acard2.getSuit();
        String suitString2=suit2.toString();
        int croupier=rank.getValue();
         aConsole.println("\n\nHouse suit is :");
         aConsole.print(suitString2);
         aConsole.println("\nHouse rank is :");
         String rankValue2=rank2.toString();
         aConsole.println(rankValue2);

        totalChips=aPlayer.getTotalChips();
        int newTotalChips=findWinner(player,croupier,wageAmount,totalChips);
        if(newTotalChips>totalChips)
        {
            result=true;
        }
        else
        {
            result=false;

        }
        return result;

        }
    public int findWinner(int player,int croupier,int wageAmount,int totalChips)
    {

        if (player > croupier) {

           totalChips = totalChips+ wageAmount;
        }
        else {

            totalChips = totalChips-wageAmount;
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

