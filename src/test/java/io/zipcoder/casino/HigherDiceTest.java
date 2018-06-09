package io.zipcoder.casino;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.zipcoder.casino.Leviathan.Games.*;
import io.zipcoder.casino.Leviathan.*;

/**
 * The test class HigherDiceTest.
 */
public class HigherDiceTest {
    Player aPlayer = new Player("Chad", 2000, 27);
    HigherDice test = new HigherDice(aPlayer);
    /**
     * Default constructor for test class DiceTest
     */
    public HigherDiceTest()
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
    public void findWinnerTest(){
        //Given
        test.findWinner(10,2,500);
        //When
        int expected=2500;
        int actual=aPlayer.getTotalChips();


        //Result
        assertEquals(actual,expected);

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


