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
        Boolean result = false;
        aConsole.println("Welcome to Casino");
        aConsole.println("Choose the game");
        aConsole.println("1.Higher Dice\n2.Higher Card\n3.Black Jack\n4.Yahtzee\n\n");

        int choice = aConsole.getIntInput("Enter your choice");
        if (choice == 1)//Higher Dice
        {
            HigherDice higherDice = new HigherDice(aPlayer);
            higherDice.playGame();
        } else if (choice == 2)//Higher Cards
        {
            HigherCards higherCards = new HigherCards(aPlayer);
            higherCards.playGame();
        } else if (choice == 3) {
            BlackJack blackJack=new BlackJack(aPlayer);
            blackJack.playGame();
        } else if (choice == 4) {
            Yahtzee yahtzee = new Yahtzee(aPlayer);
            yahtzee.playGame();
        }
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






