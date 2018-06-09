package io.zipcoder.casino.Leviathan;

import io.zipcoder.casino.Leviathan.Games.BlackJack;
import io.zipcoder.casino.Leviathan.Games.HigherCards;
import io.zipcoder.casino.Leviathan.Games.HigherDice;
import io.zipcoder.casino.Leviathan.Games.Yahtzee;
import io.zipcoder.casino.Leviathan.Interfaces.Game;


public class Table {

    Console aConsole = new Console();
    Game aGame;
    Player aPlayer;

    public Table(Player aPlayer) {
        this.aPlayer = aPlayer;
    }

    public void startGame() {
        boolean play = true;
        boolean played = false;
        aConsole.println("Welcome to The Leviathan Casino " + aPlayer.getName() + "!");

        while (play == true) {
            if (played == true) {
                aConsole.println("Welcome back to the selection table " + aPlayer.getName());
                aConsole.println("Your current chip total is " + aPlayer.getTotalChips());
            }
            int choice = 0;
            aConsole.println("Choose a game to play:");
            if (aPlayer.getTotalChips() > 0) {
                aConsole.println("1.Higher Dice\n2.Higher Card\n3.Black Jack\n4.Yahtzee\n5.Buy more Chips\n6.Cash Out\n\n");
                choice = aConsole.getIntInput("Enter your choice");
            } else {
                while (choice < 4) {
                    aConsole.println("It looks like you don't have any chips. You'll need chips to play any gambling games.");
                    aConsole.println("4.Yahtzee\n5.Buy more Chips\n6.Cash Out\n\n");
                    choice = aConsole.getIntInput("Enter your choice");
                }
            }
            if (choice == 1)//Higher Dice
            {
                aGame = new HigherDice(aPlayer);
                aGame.playGame();
                played = true;
            } else if (choice == 2)//Higher Cards
            {
                aGame = new HigherCards(aPlayer);
                aGame.playGame();
                played = true;
            } else if (choice == 3) //BlackJack
            {
                aGame = new BlackJack(aPlayer);
                aGame.playGame();
                played = true;
                aConsole.println("You Lose\n");
            } else if (choice == 4) //Yahtzee
            {
                aGame = new Yahtzee(aPlayer);
                aGame.playGame();
                played = true;
            } else if (choice == 5) // Chips
            {
                if (aPlayer.getAge() > 20) {
                    aPlayer.setTotalChips(aPlayer.getTotalChips() + aConsole.getIntInput("How many more chips would you like?"));
                    aConsole.println("Great! Here you go! Good Luck!\n");
                } else {
                    aConsole.println("You are not old enough to gamble, so we won't be able to let you purchase any chips.\n");
                }
            } else if (choice == 6) // Cash Out
            {
                play = false;
                aConsole.println("Thank you for coming to the Leviathan Casino " + aPlayer.getName());
                aConsole.println("You've cashed out " + aPlayer.getTotalChips() + " chips");
                aConsole.println("Please come again!");
            } else {
                aConsole.println("That is not an option " + aPlayer.getName() + "... Do better\n");
            }
        }

    }
}






