package io.zipcoder.casino;
import static org.junit.Assert.*;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.Die;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class DieTest {
    /**
     * The test class DieTest.
     */

        Die test = new Die();
        /**
         * Default constructor for test class DiceTest
         */
        public DieTest()
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
            test.rollADice();
            //When
            int actual = 3;
            int expected = test.getValue();
            //Result
            assertEquals(actual, expected,3);
        }

        @Test
        public void rollADiceTest2(){
            //Given
            test.rollADice();
            //When
            int actual = 2;
            int expected = test.getValue();
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

