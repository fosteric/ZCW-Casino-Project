package io.zipcoder.casino;

import io.zipcoder.casino.Leviathan.Games.HigherCards;
import io.zipcoder.casino.Leviathan.Player;
import org.junit.Assert;
import org.junit.Test;


public class HigherCardsTest {
    @Test
    public void testFindAWinner()
    {
        Player aplayer =new Player("Aleena",2000, 21);
        HigherCards higherCards=new HigherCards(aplayer);

        int expected=2500;
        higherCards.findWinner(10,2,500);
        int actual=aplayer.getTotalChips();
        Assert.assertEquals(actual,expected);


    }
}
