package io.zipcoder.casino.Leviathan.Games;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.*;
import io.zipcoder.casino.Leviathan.*;
import java.util.*;


public class Yahtzee extends DiceGame {

    Player aPlayer;
    Dice diceRoller = new Dice(5);
    Die[] dice;
    Console console = new Console();
    Map<YahtzeeField, Integer> scoreSheet = new HashMap<YahtzeeField, Integer>();


    public Yahtzee(Player aPlayer) {
        this.aPlayer = aPlayer;
        dice = diceRoller.rollAll();
    }

    public static void main(String[] args) {
        Player aPlayer = new Player("eric", 20);
        Yahtzee yahtzee = new Yahtzee(aPlayer);
        yahtzee.playGame();
    }

    public void playGame() {
        rollDice();

        String rollAgainString = userInputRollAgain();
        boolean rollAgain = userInputRollAgainBoolean(rollAgainString);

        rollAgainLoop(rollAgain);

        YahtzeeField fieldChoice = chooseYahtzeeField();
        scoreDice(fieldChoice);


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
    }

    /*
    Roll dice
     */
    public void rollDice(){
        dice = diceRoller.rollAll();
        printDice();
    }

    /*
    Display dice
     */
    public void printDice() {
        StringBuilder currentDice = new StringBuilder();
        for (int i = 0; i < dice.length; i++) {
            currentDice.append(dice[i].getValue());
            if (i < dice.length - 1) {
                currentDice.append(", ");
            }
        }
        console.println("current roll: " + currentDice.toString());
    }

    /*
    Ask user if they want to roll again
     */
    public String userInputRollAgain() {
        return aConsole.getStringInput ("Roll again?").toUpperCase();
    }

    /*
    Convert user's choice to roll again to boolean
     */
    public boolean userInputRollAgainBoolean(String userInputString){
        boolean rollAgain;
        if (userInputString.equals("YES")) {
            rollAgain = true;
        } else {
            rollAgain = false;
        }
        return rollAgain;
    }

    /*
    Allow the user to roll again up to 2 more times
     */
    public void rollAgainLoop(boolean rollAgain) {

        int rollCounter = 1;
        while (rollAgain && rollCounter <= 3) {
            //select the dice to keep
            Integer[] diceToRollAgain = userInputChooseDice();
            //roll remaining dice
            rollSelectedDiceAgain(diceToRollAgain);
            printDice();
            rollCounter++;
        }
    }

    /*
    Ask user to select which dice to roll again
     */
    public Integer[] userInputChooseDice(){
        Integer [] diceToRollAgainArray = null;
        ArrayList<Integer> diceToRollAgainList = new ArrayList<Integer>();
        boolean stillSelecting = true;
        while (stillSelecting) {
            int positionOfDiceToKeep = aConsole.getIntInput("Enter position of dice to roll again or 0 to perform roll");
            if (positionOfDiceToKeep == 0) {
                stillSelecting = false;
            } else {
                diceToRollAgainList.add(positionOfDiceToKeep);
            }
        }
        diceToRollAgainArray = diceToRollAgainList.toArray(new Integer[diceToRollAgainList.size()]);
        return diceToRollAgainArray;
    }

    /*
    Roll the selected dice again
     */
    public void rollSelectedDiceAgain(Integer... diceToRollAgain) {
        for (int i = 0; i < diceToRollAgain.length; i++) {
            dice[diceToRollAgain[i]-1].rollADice();
        }
    }



    public YahtzeeField chooseYahtzeeField() {
        String userInput = aConsole.getStringInput
                ("Which field do you want to score?").toUpperCase();
        return YahtzeeField.ACES;
    }

    public void scoreDice(YahtzeeField yahtzeeField) {
        //take in field and dice array and give a score
    }

    public void updateScoreSheet(YahtzeeField yahtzeeField, int score) {
        //Take in field and score and update sheet
    }

    public void displayScoreSheet() {
        //print score sheet
    }

}
