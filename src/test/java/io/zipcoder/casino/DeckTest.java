package io.zipcoder.casino;

import io.zipcoder.casino.Leviathan.Games.GameUtilities.Card;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.Deck;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.Rank;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.Suit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DeckTest {
    /**
     * The test class DieTest.
     */
    private Deck deck;

    /**
     * Default constructor for test class DiceTest
     */
    public DeckTest() {

    }

    /**
     * Sets up the test fixture.
     * <p>
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        deck = new Deck();
    }

    @Test
    public void drawTest() {


        //When
        Card card = deck.draw();
        Card ten = new Card(Rank.TEN, Suit.SPADES);
        //Result

        assertNotNull(ten.getRank());
        assertNotNull(ten.getSuit());
    }

    @Test
    public void removalTest() {
        //Given
        Deck deck = new Deck();
        deck.draw();
        //When
        int expected = 51;
        int actual = deck.size();
        //Result
        assertEquals(expected, actual);


    }

    /**
     * Tears down the test fixture.
     * <p>
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }
}

