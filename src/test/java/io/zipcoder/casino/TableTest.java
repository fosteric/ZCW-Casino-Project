package io.zipcoder.casino;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.zipcoder.casino.Leviathan.*;

    /**
     * The test class HigherDiceTest.
     */
    public class TableTest {
        Player aPlayer = new Player("Chad", 500, 27);
        Table test = new Table(aPlayer);
        /**
         * Default constructor for test class DiceTest
         */
        public TableTest()
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

        /**@Test
        public void findWinnerTest(){
            //Given

            //When
            int expected=2500;
            int actual=test.findWinner(10,2,500);


            //Result
            assertEquals(actual,expected);

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

