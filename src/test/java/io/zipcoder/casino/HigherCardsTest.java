package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class HigherCardsTest {
    @Test
    public void testFindAWinner()
    {

        HigherCards higherCards=new HigherCards();
      //  Player aplayer =new Player("Aleena",2000);

        int expected=2500;
        int actual=higherCards.findWinner(10,2,500,2000);
        Assert.assertEquals(actual,expected);


    }
}
