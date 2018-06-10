package io.zipcoder.casino;
import static org.junit.Assert.*;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.Dice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


    /**
     * The test class DiceTest.

     */
    public class DiceTest
    {
        Dice test = new Dice(5);
        /**
         * Default constructor for test class DiceTest
         */
        public DiceTest()
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
        public void rollAllTest(){
            //Given
            test.rollAll();

            //When
            int actual = test.getDice()[0].getValue();
            int expected = 3;

            //Result
            assertEquals(actual, expected, 3);

        }

        @Test
        public void sumAllTest(){
            //Given
            test.rollAll();

            //When
            int actual = test.sumAllDice();
            int expected = 17;

            //Result
            assertEquals(actual, expected, 13);

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

