package io.zipcoder.casino.Leviathan;
import io.zipcoder.casino.Leviathan.Interfaces.*;
import io.zipcoder.casino.Leviathan.Games.*;


public class Table {

    Console aConsole = new Console();
    Game aGame;
    Player aPlayer;

    public Table(Player aPlayer) {
        this.aPlayer = aPlayer;
    }

    public void startGame() {
        boolean play = true;
        aConsole.println("Welcome to The Leviathan Casino " + aPlayer.getName()+ "!");

        while(play == true) {
            aConsole.println("Choose a game to play:");
            aConsole.println("1.Higher Dice\n2.Higher Card\n3.Black Jack\n4.Yahtzee\n5.Leave the Table\n\n");

            int choice = aConsole.getIntInput("Enter your choice");
            if (choice == 1)//Higher Dice
            {
                aGame = new HigherDice(aPlayer);

            } else if (choice == 2)//Higher Cards
            {
                aGame = new HigherCards(aPlayer);

            } else if (choice == 3) //BlackJack
            {
                aGame = new BlackJack(aPlayer);

            } else if (choice == 4) //Yahtzee
            {
                aGame = new Yahtzee(aPlayer);

            } else if (choice == 5) // Leave
                {
                     play = false;
                }

            aGame.playGame();

            Boolean result = false;
            if (result.equals(true)) {
                aConsole.println("Congrats! You Won");
                aConsole.println("Your current available Chips");
                String availableChips = aPlayer.getTotalChips().toString();
                aConsole.println(availableChips);
            } else {
                aConsole.println("You Lose");

            }
        }

    }
}






