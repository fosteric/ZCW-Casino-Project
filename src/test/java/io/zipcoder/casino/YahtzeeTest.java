package io.zipcoder.casino;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class YahtzeeTest {

    Console console = new Console();
    Player aPlayer = new Player("eric", 20);
    Yahtzee yahtzee = new Yahtzee(aPlayer);
    Dice diceRoller = new Dice(5);
    Die[] dice;

    @Test
    public void displayDiceTest(){
        dice = yahtzee.rollAllDice();
        yahtzee.displayDice();
    }

}

