package io.zipcoder.casino;
import java.util.*;

public class Yahtzee extends DiceGame {

    Console console = new Console();
    Map<YahtzeeFields, Integer> scoreSheet = new HashMap<YahtzeeFields, Integer>();
    Dice dice = new Dice();
    Die[] diceRoll;

    public boolean playGame(Player aPlayer) {
        //roll dice (1)
            //roll all 5 dice
        //See current dice
        //Use roll or roll again?
            //If roll again, select which dice to keep
                //roll remaining dice (2)
            //If use roll, select a field
        //See current dice
        //Use roll or roll again?
            //If roll again, select which dice to keep
                //roll remaining dice (3)
            //If use roll, select a field
        //See current dice
        //Select a field

        //other things you might want to do..
            //See fields and scoring formula
            //see current score sheet
            //quit game


        return false;
    }

    public Die[] rollAllDice(){
        //roll and return the entire array of dice
        return null;
    }

    public void rollAgain(int... diePosition){
        //roll specific die in the dice array
    }

    public int scoreRoll(YahtzeeFields yahtzeeField){
        //take in field and dice array and give a score
        return -1;
    }

    public void updateScoreSheet(YahtzeeFields yahtzeeField, int score){
        //Take in field and score and update sheet
    }

    public void displayScoreSheet(){
        //print score sheet
    }

}
