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
    public void getDiceValuesTest(){
//        //Given
//        Die testDie = new Die();
//        testDie.rollADice();
//        Die[] testDieArray = {testDie, testDie, testDie, testDie, testDie};
//        int testDieValue = testDie.getValue();
//        int[] expectedArray = {testDieValue, testDieValue, testDieValue, testDieValue, testDieValue};
//        //Actual
//        boolean actual = Arrays.equals(actualArray, expectedArray);
//        //Expected
//        boolean expected = true;
//        //Test
//        assertEquals(expected, actual);
    }

    @Test
    public void rollSelectedDiceAgainTest(){
        //Given

        yahtzee.rollSelectedDiceAgain(1,2,3,4,5);
        //Actual

    }

    @Test
    public void turnTurnRollAgainListToArray(){
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
    public void userInputRollAgainBooleanTestYes(){
        //Actual
        boolean actual = yahtzee.userInputYesNoToBoolean("YES");
        //Expected
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void userInputRollAgainBooleanTestNo(){
        //Actual
        boolean actual = yahtzee.userInputYesNoToBoolean("NO");
        //Expected
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void isYahtzeeFieldValidTest(){
        //Actual
        boolean actual = yahtzee.isValidYahtzeeField("ACES");
        //Expected
        boolean expected = true;
        //Test
        assertEquals(actual, expected);
    }

    @Test
    public void isYahtzeeFieldValidTest2(){
        //Actual
        boolean actual = yahtzee.isValidYahtzeeField("ONES");
        //Expected
        boolean expected = false;
        //Test
        assertEquals(actual, expected);
    }
}