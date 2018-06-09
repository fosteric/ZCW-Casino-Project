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





}

