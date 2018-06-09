package io.zipcoder.casino.Leviathan;


public class Casino {
    Console aConsole = new Console();
    Player aPlayer;
    Table aTable;

    public void setaPlayer() {
        String name = aConsole.getStringInput("What is your name?");
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        int age = aConsole.getIntInput("What is your age?");
        int chips = 0;
        if (age > 20) {
            chips = aConsole.getIntInput("How many chips would you like to purchase?");
        } else {
            aConsole.println("You are not old enough to gamble, so we won't be able to let you purchase any chips.");
        }
        aPlayer = new Player(name, chips, age);
    }

    public void run() {
        aTable = new Table(aPlayer);
        aTable.startGame();
    }
}
