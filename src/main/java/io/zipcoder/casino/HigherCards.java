package io.zipcoder.casino;

public class  HigherCards extends CardGame implements Gambling{

     public boolean playGame(Player aPlayer) {
        Boolean result;
        int player=draw();
        int croupier=draw();
        if(player>croupier)
        {
            result=true;
            aPlayer.totalChips=aPlayer.getTotalChips()+bet;
        }
        else
        {
            result=false;
            aPlayer.totalChips=aPlayer.getTotalChips()-bet;
        }

        return result;
    }

    public int wageMoney() {
        return 0;
    }
}
