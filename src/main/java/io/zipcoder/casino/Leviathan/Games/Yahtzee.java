package io.zipcoder.casino.Leviathan.Games;

import io.zipcoder.casino.Leviathan.Games.GameUtilities.*;
import io.zipcoder.casino.Leviathan.*;

import java.util.*;


public class Yahtzee extends DiceGame {

    Player aPlayer;
    Dice diceRoller = new Dice(5);
    Die[] dice = diceRoller.rollAll();
    int[] diceValueCounts = new int[6];
    Console aConsole = new Console();
    boolean playAgain;
    boolean scoreSheetFull = false;
    Map<YahtzeeField, Integer> scoreSheet = new LinkedHashMap<YahtzeeField, Integer>();


    public Yahtzee(Player aPlayer) {
        this.aPlayer = aPlayer;
    }

    //==================================================================================
    // PLAY GAME METHOD
    //==================================================================================

    public void playGame() {

        aConsole.println("Welcome to Yahtzee " + aPlayer.getName());

        boolean playAgain = true;
        while (playAgain) {

            createBlankScoreSheet();
            printScoreSheet();

            while (!scoreSheetFull) {
                rollDice();

                rollAgainLoop();

                YahtzeeField fieldChoice = chooseYahtzeeField();
                int score = scoreDice(fieldChoice);
                updateScoreSheet(fieldChoice, score);
                printScoreSheet();
                scoreSheetFull = checkScoreSheetForCompletion();
            }

            int totalScore = getTotalScore();
            printEndOfGameMessage(totalScore);
        }

    }

    //==================================================================================
    // SCORE SHEET METHODS
    //==================================================================================

    /*
    Create blank score sheet
     */
    public void createBlankScoreSheet() {
        for (YahtzeeField field : YahtzeeField.values()) {
            scoreSheet.put(field, null);
        }
    }

    /*
    Check score sheet for completion
     */
    public boolean checkScoreSheetForCompletion() {
        for (Map.Entry<YahtzeeField, Integer> entry : scoreSheet.entrySet()) {
            Integer value = entry.getValue();
            if (value == null) {
                return false;
            }
        }
        return true;
    }

    /*
    Print score sheet
     */
    public void printScoreSheet() {
        aConsole.println("Scoresheet: " + scoreSheet.toString());
    }

    /*
    Get total score
     */
    public int getTotalScore() {
        int sumOfUpperSection = getUpperSectionScore();
        int bonus = 0;
        if (sumOfUpperSection >= 63){
            bonus = 35;
        }
        int sumOfLowerSection = getLowerSectionScore();
        return sumOfUpperSection + bonus + sumOfLowerSection;
    }

    /*
    Get upper section score
     */
    public int getUpperSectionScore(){
        int upperScore = 0;
        Iterator it = scoreSheet.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry scoreEntry = (Map.Entry)it.next();
            if (scoreEntry.getKey() == YahtzeeField.ACES || scoreEntry.getKey() == YahtzeeField.TWOS ||
                    scoreEntry.getKey() == YahtzeeField.THREES || scoreEntry.getKey() == YahtzeeField.FOURS ||
                    scoreEntry.getKey() == YahtzeeField.FIVES || scoreEntry.getKey() == YahtzeeField.SIXES){
                upperScore += (int)(scoreEntry.getValue());
            }
        }
        return upperScore;
    }

    /*
    Get lower section score
     */
    public int getLowerSectionScore(){
        int lowerScore = 0;
        Iterator it = scoreSheet.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry scoreEntry = (Map.Entry)it.next();
            if (scoreEntry.getKey() == YahtzeeField.THREEOFAKIND || scoreEntry.getKey() == YahtzeeField.FOUROFAKIND ||
                    scoreEntry.getKey() == YahtzeeField.FULLHOUSE || scoreEntry.getKey() == YahtzeeField.SMSTRAIGHT ||
                    scoreEntry.getKey() == YahtzeeField.LGSTRAIGHT || scoreEntry.getKey() == YahtzeeField.YAHTZEE ||
                    scoreEntry.getKey() == YahtzeeField.CHANCE){
                lowerScore += (int)(scoreEntry.getValue());
            }
        }
        return lowerScore;
    }

     /*
    Print end of game stats
     */
     public void printEndOfGameMessage(int totalScore){
         aConsole.println("Game over!");
         aConsole.println("Your total score is: " + totalScore);
         if(aConsole.yesOrNo("Would you like to play again?").equalsIgnoreCase("no")){
             playAgain= false;
         }
     }

    //==================================================================================
    // SCORING ROLL METHODS
    //==================================================================================

    /*
    See fields and formula for score
     */
    public void printRules(){
        aConsole.println("Roll 5 dice up to 3 times and try to get the highest score");
    }

    /*
    Choose yahtzee field to score
     */
    public YahtzeeField chooseYahtzeeField() {
        boolean inputValid = true;
        boolean inputIsFree = true;
        String userInput;
        do {
            userInput = aConsole.getStringInput
                    ("Which field do you want to score?").toUpperCase();
            inputValid = isYahtzeeField(userInput);
            inputIsFree = isYahtzeeFieldFree(userInput);
        } while(!inputValid && !inputIsFree);
        return YahtzeeField.valueOf(userInput);
    }

    /*
    Check if yahtzee field is valid
     */
    public boolean isYahtzeeField(String userInput) {
        YahtzeeField[] yahtzeeFields = YahtzeeField.values();
        for (YahtzeeField aYahtzeeField : yahtzeeFields) {
            if (aYahtzeeField.name().equals(userInput)) {
                return true;
            }
        }
        return false;
    }

    /*
    Check if yahtzee field is free
     */
    public boolean isYahtzeeFieldFree(String userInput) {
        boolean inputIsFree = true;
        if(scoreSheet.get(YahtzeeField.valueOf(userInput)) != null){
            inputIsFree = false;
        }
        return inputIsFree;
    }

    /*
    Score dice
    */
    public int scoreDice(YahtzeeField yahtzeeField) {

        updateDiceValues();

        int score = 0;
        switch (yahtzeeField) {
            case ACES:
                score = scoreCountFields(1);
                break;
            case TWOS:
                score = scoreCountFields(2);
                break;
            case THREES:
                score = scoreCountFields(3);
                break;
            case FOURS:
                score = scoreCountFields(4);
                break;
            case FIVES:
                score = scoreCountFields(5);
                break;
            case SIXES:
                score = scoreCountFields(6);
                break;
            case THREEOFAKIND:
                score = scoreOfAKind(ofAKindCriteria(3));
                break;
            case FOUROFAKIND:
                score = scoreOfAKind(ofAKindCriteria(4));
                break;
            case FULLHOUSE:
                score = scoreFullHouse(fullHouseCriteria());
                break;
            case SMSTRAIGHT:
                score = scoreSmStraight(smStraighCriteria());
                break;
            case LGSTRAIGHT:
                score = scoreLgStraight(lgStraightCriteria());
                break;
            case YAHTZEE:
                score = scoreYahtzee(ofAKindCriteria(5));
                break;
            case CHANCE:
                score = scoreOfAKind(ofAKindCriteria(1));
                break;
        }
        return score;
    }

    /*
    Get count of each value in dice
    */
    public void updateDiceValues(){
        resetDiceValues();
        for (Die d : dice){
            diceValueCounts[d.getValue()-1]++;
        }
    }

    /*
    Reset count of each value in dice
    */
    public void resetDiceValues(){
        for (int i=0; i < diceValueCounts.length; i++){
            diceValueCounts[i] = 0;
        }
    }

    /*
    Check "of a kind" criteria is met
    */
    public boolean ofAKindCriteria(int ofAKind){
        for (int count : diceValueCounts){
            if (count >= ofAKind){
                return true;
            }
        }
        return false;
    }

    /*
    Score dice "of a kind" fields: 3 of a kind, 4 of a kind, or chance
    */
    public int scoreOfAKind(boolean meetsOfAKindCriteria) {
        int score = 0;
        if (meetsOfAKindCriteria) {
            for (Die d : dice){
                score += d.getValue();
            }
        }
        return score;
    }

    /*
    Score yahtzee
     */
    public int scoreYahtzee(boolean meetsOfAKindCriteria){
        int score = 0;
        if (meetsOfAKindCriteria){
            score = 50;
        }
        return score;
    }

    /*
    Check Full House criteria is met
    */
    public boolean fullHouseCriteria(){
        int i = 0;
        for (int count : diceValueCounts){
            if (count >= 2){
                i++;
            }
        }
        if(i==2){
            return true;
        }
        return false;
    }

    /*
    Score Full House
     */
    public int scoreFullHouse(boolean meetsFullHouseCriteria){
        int score = 0;
        if (meetsFullHouseCriteria){
            score = 25;
        }
        return score;
    }

    /*
    Check Small Straight criteria is met
    */
    public boolean smStraighCriteria(){
        boolean meetsCriteria = false;
        int i = 0;
        for (int count : diceValueCounts){
            if (count > 1){
                i++;
            }
        }
        if(i<=1){
            meetsCriteria = true;
        }
        return meetsCriteria;
    }

    /*
    Score SM Straight
     */
    public int scoreSmStraight(boolean meetsSmStraightCriteria){
        int score = 0;
        if (meetsSmStraightCriteria){
            score = 30;
        }
        return score;
    }

    /*
    Check Large Straight criteria is met
    */
    public boolean lgStraightCriteria(){
        boolean meetsCriteria = false;
        int i = 0;
        for (int count : diceValueCounts){
            if (count > 1){
                i++;
            }
        }
        if(i<1){
            meetsCriteria = true;
        }
        return meetsCriteria;
    }

    /*
    Score LG Straight
     */
    public int scoreLgStraight(boolean meetsLgStraightCriteria){
        int score = 0;
        if (meetsLgStraightCriteria){
            score = 40;
        }
        return score;
    }

    /*
    Score dice "count" fields: aces, twos, threes, fours, fives, or sixes
    */
    public int scoreCountFields(int countField) {
        return diceValueCounts[countField-1] * countField;
    }

    /*
    Update score sheet with scored value
    */
    public void updateScoreSheet(YahtzeeField yahtzeeField, int score) {
        scoreSheet.put(yahtzeeField, score);
    }

    //==================================================================================
    // ROLLING DICE METHODS
    //==================================================================================

    /*
    Roll dice
     */
    public void rollDice() {
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
        aConsole.println("current roll: " + currentDice.toString());
    }

    /*
    Ask user if they want to roll again
     */
    public String userInputRollAgain() {
        return aConsole.yesOrNo("Roll again?").toUpperCase();
    }

    /*
    Convert user's choice to roll again to boolean
     */
    public boolean userInputRollAgainBoolean(String userInputString) {
        if (userInputString.equals("YES")) {
            return true;
        } else {
            return false;
        }
    }

    /*
    Allow the user to roll again up to 2 more times
     */
    public void rollAgainLoop() {

        String rollAgainString = userInputRollAgain();
        boolean rollAgain = userInputRollAgainBoolean(rollAgainString);

        int rollCounter = 1;
        while (rollAgain) {
            //select the dice to keep
            Integer[] diceToRollAgain = userInputChooseDice();
            //roll remaining dice
            rollSelectedDiceAgain(diceToRollAgain);
            printDice();
            rollCounter++;
            if (rollCounter >= 3) {
                break;
            }

            rollAgainString = userInputRollAgain();
            rollAgain = userInputRollAgainBoolean(rollAgainString);
        }
    }

    /*
    Ask user to select which dice to roll again
     */
    public Integer[] userInputChooseDice() {
        Integer[] diceToRollAgainArray = null;
        ArrayList<Integer> diceToRollAgainList = new ArrayList<Integer>();
        boolean stillSelecting = true;
        boolean error = false;
        do {
            String positionOfDiceToKeep = aConsole.getStringInput("Enter position of dice to roll again or enter to perform roll");
            if (Integer.parseInt(positionOfDiceToKeep) < 0 ||
                    Integer.parseInt(positionOfDiceToKeep) > 5){
                error = true;
            }
            else if (positionOfDiceToKeep.equals("")) {
                stillSelecting = false;
            } else {
                diceToRollAgainList.add(Integer.parseInt(positionOfDiceToKeep));
            }
        } while (stillSelecting && error );
        diceToRollAgainArray = diceToRollAgainList.toArray(new Integer[diceToRollAgainList.size()]);
        return diceToRollAgainArray;
    }

    /*
    Roll the selected dice again
     */
    public void rollSelectedDiceAgain(Integer... diceToRollAgain) {
        for (int i = 0; i < diceToRollAgain.length; i++) {
            dice[diceToRollAgain[i] - 1].rollADice();
        }
    }
}
