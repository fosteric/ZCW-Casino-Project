package io.zipcoder.casino;
import java.util.*;

public class Yahtzee extends DiceGame {

    Console console = new Console();
    Map<YahtzeeFields, Integer> scoreSheet = new HashMap<YahtzeeFields, Integer>();
    Dice diceRoller;
    Die[] dice;
    Player aPlayer;

    public Yahtzee(Player aPlayer){
        this.aPlayer = aPlayer;
        diceRoller = new Dice(5);
    }

    public boolean playGame() {
        //roll dice (1)
            //roll all 5 dice
        dice = rollAllDice();
        //See current dice
        displayDice();
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
        return diceRoller.rollAll();
    }

    public void rollSelectDice(int... diePosition){
        for (int i = 0; i < diePosition.length; i++){
            dice[diePosition[i]].rollADice();
        }
    }

    public void displayDice(){
        StringBuilder currentDice = new StringBuilder();
        for(int i = 0; i<dice.length; i++){
            currentDice.append(dice[i].getValue());
            if(i<dice.length-1) {
                currentDice.append(", ");
            }
        }
        console.println("current roll: " + currentDice.toString());
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
