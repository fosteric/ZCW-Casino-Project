package io.zipcoder.casino;

import org.junit.Assert;
>>>>>>> dev
import org.junit.Test;

public class HigherCardsTest {
    @Test
<<<<<<< HEAD
    public void testHigherClassTest()
    {
        Boolean expected=true;
        HigherCards h=new HIgherCards();
        Player player =new Player();
        Boolean actual=h.playGame(player);//?

    }
}
=======
    public void testFindAWinner()
    {
        Player aplayer =new Player("Aleena",2000);
        HigherCards higherCards=new HigherCards(aplayer);

        int expected=2500;
        int actual=higherCards.findWinner(10,2,500,2000);
        Assert.assertEquals(actual,expected);


    }
}
