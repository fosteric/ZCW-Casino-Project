package io.zipcoder.casino;


public class Casino {
    Console aConsole = new Console();
    Player aPlayer;
    Table aTable;

    public void setaPlayer(){

    }

    public void run(){
        aTable= new Table(aPlayer);
        aTable.startGame();
    }
}
