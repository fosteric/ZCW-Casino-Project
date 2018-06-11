package io.zipcoder.casino;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.*;
import io.zipcoder.casino.Leviathan.*;
import io.zipcoder.casino.Leviathan.Games.*;
import java.util.*;

public class YahtzeeTest {

    Yahtzee yahtzee;
    Player aPlayer;

    public YahtzeeTest(){
        aPlayer = new Player("eric", 20, 18);
        yahtzee = new Yahtzee(aPlayer);
    }

    @Test
    public void scoreCountFieldsTestPositive(){
        //Actual
        int actual = yahtzee.scoreCountFields(2);
        //Expected
        int[] getDiceValueCounts = yahtzee.getDiceValueCounts();
        int expected = getDiceValueCounts[1]*2;
        //Test
        assertEquals(expected, actual);
    }

    @Test
    public void scoreThreeOfAKindTestPositive(){
        //Actual
        int actual = yahtzee.scoreOfAKind(true);
        //Expected
        int expected = yahtzee.sumOfDice();
        //Test
        assertEquals(expected, actual);
    }

    @Test
    public void scoreThreeOfAKindTestNegative(){
        //Actual
        int actual = yahtzee.scoreOfAKind(false);
        //Expected
        int expected = 0;
        //Test
        assertEquals(expected, actual);
    }

    @Test
    public void scoreYahtzeeTestPositive(){
        //Actual
        int actual = yahtzee.scoreYahtzee(true);
        //Expected
        int expected = 50;
        //Test
        assertEquals(expected, actual);
    }

    @Test
    public void scoreYahtzeeTestNegative(){
        //Actual
        int actual = yahtzee.scoreYahtzee(false);
        //Expected
        int expected = 0;
        //Test
        assertEquals(expected, actual);
    }

    @Test
    public void scoreFullHouseTestPositive(){
        //Actual
        int actual = yahtzee.scoreFullHouse(true);
        //Expected
        int expected = 25;
        //Test
        assertEquals(expected, actual);
    }

    @Test
    public void scoreFullHouseTestNegative(){
        //Actual
        int actual = yahtzee.scoreFullHouse(false);
        //Expected
        int expected = 0;
        //Test
        assertEquals(expected, actual);
    }

    @Test
    public void scoreSmStraightTestPositive(){
        //Actual
        int actual = yahtzee.scoreSmStraight(true);
        //Expected
        int expected = 30;
        //Test
        assertEquals(expected, actual);
    }

    @Test
    public void scoreSmStraightTestNegative(){
        //Actual
        int actual = yahtzee.scoreSmStraight(false);
        //Expected
        int expected = 0;
        //Test
        assertEquals(expected, actual);
    }

    @Test
    public void scoreLgStraightTestPositive(){
        //Actual
        int actual = yahtzee.scoreLgStraight(true);
        //Expected
        int expected = 40;
        //Test
        assertEquals(expected, actual);
    }

    @Test
    public void scoreLgStraightTestNegative(){
        //Actual
        int actual = yahtzee.scoreLgStraight(false);
        //Expected
        int expected = 0;
        //Test
        assertEquals(expected, actual);
    }


    @Test
    public void turnTurnRollAgainListToArrayTest(){
        //Given
        List<Integer> testUserInputList = new ArrayList<Integer>();
        testUserInputList.add(1);
        testUserInputList.add(2);
        testUserInputList.add(3);
        //Actual
        Integer[] actual = yahtzee.turnRollAgainListToArray(testUserInputList);
        //Expected
        Integer[] expected = {1,2,3};
        //Test
        assertEquals(expected,actual);
    }

    @Test
    public void userInputRollAgainBooleanTestPositive(){
        //Actual
        boolean actual = yahtzee.userInputYesNoToBoolean("YES");
        //Expected
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void userInputRollAgainBooleanTestNegative(){
        //Actual
        boolean actual = yahtzee.userInputYesNoToBoolean("NO");
        //Expected
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void isYahtzeeFieldValidTestPositive(){
        //Actual
        boolean actual = yahtzee.isValidYahtzeeField("ACES");
        //Expected
        boolean expected = true;
        //Test
        assertEquals(actual, expected);
    }

    @Test
    public void isYahtzeeFieldValidTestNegative(){
        //Actual
        boolean actual = yahtzee.isValidYahtzeeField("ONES");
        //Expected
        boolean expected = false;
        //Test
        assertEquals(actual, expected);
    }
}