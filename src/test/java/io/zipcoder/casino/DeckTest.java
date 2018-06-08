package io.zipcoder.casino;

import static org.junit.Assert.*;

import io.zipcoder.casino.Leviathan.Games.GameUtilities.Card;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.Deck;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.Rank;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.Suit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DeckTest {
    /**
     * The test class DieTest.
     */

    private Card card;
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
        Object card = deck.draw();
        Card ten = new Card(Rank.TEN, Suit.SPADES);
        //Result

        assertNotNull(ten.getRank());
        assertNotNull(ten.getSuit());
    }

    @Test
    public void removeTest() {


        //When

        //Result




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

