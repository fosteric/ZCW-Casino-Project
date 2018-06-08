package io.zipcoder.casino.Leviathan;
import io.zipcoder.casino.Leviathan.Interfaces.*;
import io.zipcoder.casino.Leviathan.Games.*;


public class Table {

    Console aConsole = new Console();
    Game aGame;
    Player aPlayer;

    public Table(Player aPlayer){
        this.aPlayer = aPlayer;
    }

    public void startGame(){

        aConsole.println("Welcome to Casino");
        aConsole.println("Choose the game");
        aConsole.println("1.Higher Dice\n2.Higher Card\n3.Black Jack\n4.Yahtzee\n");

        int choice=aConsole.getIntInput("Enter your choice");
        if(choice==1)
        {

        }
        else if(choice==2)
        {
            HigherCards higherCards=new HigherCards(aPlayer);
            higherCards.playGame();
        }


    }
}





