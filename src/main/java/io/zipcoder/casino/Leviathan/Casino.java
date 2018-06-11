package io.zipcoder.casino.Leviathan;


public class Casino {
    Console aConsole = new Console();
    Player aPlayer;
    Table aTable;

    public void setaPlayer() {
        String name = aConsole.getStringInput("What is your name?");
        aPlayer = new Player(name.substring(0, 1).toUpperCase() + name.substring(1),0,aConsole.getIntInput("What is your age?"));
        if (aPlayer.getAge() > 20) {
            aPlayer.setTotalChips(aConsole.getIntInput("How many chips would you like to purchase?"));
        } else {
            aConsole.println("You are not old enough to gamble, so we won't be able to let you purchase any chips.");
        }
    }

    public void run() {
        aTable = new Table(aPlayer);
        aTable.startGame();
    }
}
