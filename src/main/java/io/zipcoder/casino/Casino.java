package io.zipcoder.casino;


public class Casino {
    Console aConsole = new Console();
    Player aPlayer;
    Table aTable;

    public void setaPlayer(){
        String name= aConsole.getStringInput("What is your name?");
        int chips= aConsole.getIntInput("How many chips do you want?");
        aPlayer = new Player(name, chips);
    }

    public void run(){
        aTable= new Table(aPlayer);
        aTable.startGame();
    }
}
