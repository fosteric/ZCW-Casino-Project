package io.zipcoder.casino;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.*;
import io.zipcoder.casino.Leviathan.*;
import io.zipcoder.casino.Leviathan.Games.*;

public class YahtzeeTest {

    Yahtzee yahtzee;
    Player aPlayer;
    Dice diceRoller;
    Die[] dice;
    Console console = new Console();

    public YahtzeeTest(){
        this.aPlayer = new Player("eric", 20, 18);
        this.yahtzee = new Yahtzee(aPlayer);
    }

    @Test
    public void userInputRollAgainBooleanTest(){
        //Actual
        boolean actual = yahtzee.userInputRollAgainBoolean("YES");
        //Expected
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void rollSelectedDiceAgainTest(){
        yahtzee.printDice();
        yahtzee.rollSelectedDiceAgain(3,5);
        yahtzee.printDice();
    }

    @Test
    public void isYahtzeeFieldTest(){
        //Actual
        boolean actual = yahtzee.isYahtzeeField("ACES");
        boolean actual2 = yahtzee.isYahtzeeField("ONES");
        boolean actual3 = yahtzee.isYahtzeeField("TWOS");
        boolean actual4 = yahtzee.isYahtzeeField("SEVENS");
        //Expected
        boolean expected = true;
        boolean expected2 = false;
        boolean expected3 = true;
        boolean expected4 = false;
        //Test
        assertEquals(actual, expected);
        assertEquals(actual2, expected2);
        assertEquals(actual3, expected3);
        assertEquals(actual4, expected4);
    }




}

