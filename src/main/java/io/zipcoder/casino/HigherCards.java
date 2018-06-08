package io.zipcoder.casino;

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
        int player=10;
        int croupier=2;

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

