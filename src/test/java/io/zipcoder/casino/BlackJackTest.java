package io.zipcoder.casino;

import io.zipcoder.casino.Leviathan.Games.BlackJack;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.Card;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.Rank;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.Suit;
import io.zipcoder.casino.Leviathan.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BlackJackTest {

    private BlackJack testBlackJack;

    @Before
    public void setUp() {
        Player p = new Player("name", 25, 25);
        this.testBlackJack = new BlackJack(p);
    }

    @Test
    public void testStartPlayerScore() {
        //Given

        //When
        int expected = 8;
        int actual = 8;
        //Result
        assertEquals(actual, expected);
    }

    @Test
    public void testStartHouseScore() {
        //Given

        //When
        int expected = 21;
        int actual = 21;
        //Result
        assertEquals(actual, expected);
    }

    @Test
    public void testDrawNewHandHasTwoCards() {
        int expected = 2;
        int actual = testBlackJack.drawNewHand().size();

        assertEquals(expected, actual);
    }




    @Test
    public void testGetHandTotal() {
        Card c1 = new Card(Rank.FOUR, Suit.CLUBS);
        Card c2 = new Card(Rank.EIGHT, Suit.CLUBS);
        Card c3 = new Card(Rank.TWO, Suit.CLUBS);

        List<Card> hand = new ArrayList<>();
        hand.add(c1);
        hand.add(c2);
        hand.add(c3);

        int expected = 14;
        int actual = testBlackJack.getHandTotal(hand);

        assertEquals(expected, actual);
    }


    @Test
    public void testHandToString() {
        Card c1 = new Card(Rank.FOUR, Suit.CLUBS);
        Card c2 = new Card(Rank.EIGHT, Suit.CLUBS);
        Card c3 = new Card(Rank.TWO, Suit.CLUBS);

        List<Card> hand = new ArrayList<>();
        hand.add(c1);
        hand.add(c2);
        hand.add(c3);

        String expected = "FOUR of CLUBS\n" +
                "EIGHT of CLUBS\n" +
                "TWO of CLUBS\n";
        String actual = testBlackJack.handToString(hand);

        System.out.println(actual);

        assertEquals(expected, actual);
    }
}
