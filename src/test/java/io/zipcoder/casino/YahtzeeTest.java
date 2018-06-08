package io.zipcoder.casino;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.*;
import io.zipcoder.casino.Leviathan.*;

public class YahtzeeTest {

    /**
     * The test class DieTest.
     */

    Dice dice = new Dice();
    Die[] diceRoll;

    /**
     * Default constructor for test class DiceTest
     */
    public YahtzeeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    @Test
    public void rollADiceTest(){
        //Given

        //When
        int actual = 3;
        int expected = test.rollADice();
        //Result
        assertEquals(actual, expected,3);
    }

    @Test
    public void rollADiceTest2(){
        //Given

        //When
        int actual = 2;
        int expected = test.rollADice();
        //Result
        assertEquals(actual, expected,4);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}

