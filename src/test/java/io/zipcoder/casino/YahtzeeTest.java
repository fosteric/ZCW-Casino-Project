package io.zipcoder.casino;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class YahtzeeTest {

    Console console = new Console();
    Player aPlayer;
    Yahtzee yahtzee;
    Dice diceRoller;
    Die[] dice;

    public YahtzeeTest(){
        aPlayer = new Player("eric", 20);
        yahtzee = new Yahtzee(aPlayer);
        diceRoller = new Dice(5);
    }

    @Test
    public void displayDice(){
        yahtzee.displayDice();
    }

    @Test
    public void rollSelectDice(){

    }



}

