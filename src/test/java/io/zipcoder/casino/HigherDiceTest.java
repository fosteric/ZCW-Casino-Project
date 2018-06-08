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
    Player aPlayer = new Player("Chad", 500);
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

    /**    @Test
    public void wageMoneyTest(){
        //Given
        test.wageMoney().;
        int sum = 0;

        for(int i = 0; i< test.getDice().length; i++){
            sum+= test.getDice()[i].getValue();
        }
        //When

        int actual = sum;
        int expected = 17;
        //Result
        assertEquals(actual, expected, 13);

    }*/

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


