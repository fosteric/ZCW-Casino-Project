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
    public void printDiceTest(){
        //Given
        int[] diceValuesTest = {1,2,3,4,5};
        //Actual
        yahtzee.printDice(diceValuesTest);
        //Expected
            //Print dice with values from 1-5;
        //Test
            //Check console display for dice values 1-5;
    }

    @Test
    public void rollSelectedDiceAgainTest(){

        //Given
        yahtzee.rollSelectedDiceAgain(1,3,5);
    }

    @Test
    public void turnUserInputRollAgainToArray(){
        //Given
        List<Integer> testUserInputList = new ArrayList<Integer>();
        testUserInputList.add(1);
        testUserInputList.add(2);
        testUserInputList.add(3);
        //Actual
        Integer[] actual = yahtzee.turnUserInputRollAgainToArray(testUserInputList);
        //Expected
        Integer[] expected = {1,2,3};
        //Test
        assertEquals(expected,actual);

    }

    @Test
    public void userInputChooseDiceTest(){

    }

    @Test
    public void rollAgainLoopTest(){

    }

    @Test
    public void userInputRollAgainBooleanTest(){
        //Actual
        boolean actual = yahtzee.userInputRollAgainBoolean("YES");
        //Expected
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void userInputRollAgainTest(){

    }

    @Test
    public void rollDiceTest(){
        //Given
        Die[] dice = yahtzee.rollDice();
        //Actual
        boolean actual = dice instanceof Die[];
        //Expected
        boolean expected = true;
        //Test
        assertEquals(expected, actual);
    }

    @Test
    public void isYahtzeeFieldValidTest(){
        //Actual
        boolean actual = yahtzee.isValidYahtzeeField("ACES");
        boolean actual2 = yahtzee.isValidYahtzeeField("ONES");
        boolean actual3 = yahtzee.isValidYahtzeeField("TWOS");
        boolean actual4 = yahtzee.isValidYahtzeeField("SEVENS");
        //Expected
        boolean expected = true;
        boolean expected2 = false;
        boolean expected3 = true;
        boolean expected4 = false;
        //Test
        assertEquals(actual, expected);
        assertEquals(actual2, expected2);
        assertEquals(actual3, expected3);
        assertEquals(actual4, expected4);
    }




}

