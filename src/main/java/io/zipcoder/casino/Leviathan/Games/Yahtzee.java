package io.zipcoder.casino.Leviathan.Games;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.*;
import io.zipcoder.casino.Leviathan.*;
import java.util.*;


public class Yahtzee extends DiceGame {

    Player aPlayer;
    Dice diceRoller;
    Die[] dice;
    Console console;
    Map<YahtzeeField, Integer> scoreSheet;


    public Yahtzee(Player aPlayer) {
        this.aPlayer = aPlayer;
        diceRoller = new Dice(5);
        scoreSheet = new LinkedHashMap<YahtzeeField, Integer>();
        dice = diceRoller.rollAll();
    }

    public static void main(String[] args) {
        Player aPlayer = new Player("eric", 20, 18);
        Yahtzee yahtzee = new Yahtzee(aPlayer);
        yahtzee.playGame();
    }

    //==================================================================================
    // PLAY GAME METHOD
    //==================================================================================

    public void playGame() {

        createBlankScoreSheet();
        printScoreSheet();

        boolean scoreSheetFull = checkScoreSheetForCompletion();

        while (!scoreSheetFull) {
            rollDice();

            rollAgainLoop();

            YahtzeeField fieldChoice = chooseYahtzeeField();
            int score = scoreDice(fieldChoice);
            updateScoreSheet(fieldChoice, score);
        }

    }

    //==================================================================================
    // SCORE SHEET METHODS
    //==================================================================================

    /*
    Create blank score sheet
     */
    public void createBlankScoreSheet(){
        for (YahtzeeField field : YahtzeeField.values()){
            scoreSheet.put(field, null);
        }
    }

    /*
    Check score sheet for completion
     */
    public boolean checkScoreSheetForCompletion(){

        for(Map.Entry<YahtzeeField, Integer> entry : scoreSheet.entrySet()){
            Integer value = entry.getValue();
            if (value == null){
                return false;
            }
        }

        return true;
    }

    /*
    Print score sheet
     */
    public void printScoreSheet(){
        console.println("Scoresheet: " + scoreSheet.toString());
    }

    //==================================================================================
    // SCORING ROLL METHODS
    //==================================================================================

    /*
    See fields and formula for score
     */

    public YahtzeeField chooseYahtzeeField() {
        String userInput = aConsole.getStringInput
                ("Which field do you want to score?").toUpperCase();
        return YahtzeeField.ACES;
    }

    public int scoreDice(YahtzeeField yahtzeeField) {
        //take in field and dice array and give a score
        return -1;
    }

    public void updateScoreSheet(YahtzeeField yahtzeeField, int score) {
        //Take in field and score and update sheet
    }

    //==================================================================================
    // ROLLING DICE METHODS
    //==================================================================================

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
    public void rollAgainLoop() {

        String rollAgainString = userInputRollAgain();
        boolean rollAgain = userInputRollAgainBoolean(rollAgainString);

        int rollCounter = 1;
        while (rollCounter <= 3 && rollAgain) {
            //select the dice to keep
            Integer[] diceToRollAgain = userInputChooseDice();
            //roll remaining dice
            rollSelectedDiceAgain(diceToRollAgain);
            printDice();
            rollCounter++;
            if (rollCounter >=3){break;}

            rollAgainString = userInputRollAgain();
            rollAgain = userInputRollAgainBoolean(rollAgainString);
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



}
