package io.zipcoder.casino;
import static org.junit.Assert.*;
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
            int sum = 0;

            for(int i = 0; i< test.getDice().length; i++){
                sum+= test.getDice()[i].getValue();
            }
            //When
            int actual = 5;
            int expected = sum;
            //Result
            assertEquals(actual, expected, 20);
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

