package io.zipcoder.casino.Leviathan.Games;

import io.zipcoder.casino.Leviathan.Games.GameUtilities.*;
import io.zipcoder.casino.Leviathan.*;

import java.util.*;


public class Yahtzee extends DiceGame {

    //==================================================================================
    // Fields
    //==================================================================================
    private Console aConsole = new Console();
    private Player aPlayer;
    private Map<YahtzeeField, Integer> scoreSheet = new LinkedHashMap<>();
    private Dice diceRoller = new Dice(5);
    private Die[] dice = diceRoller.rollAll();
    private int[] diceValues = new int[5];
    private int[] diceValueCounts = new int[6];
    private boolean playAgain = true;

    //==================================================================================
    // Constructor
    //==================================================================================
    public Yahtzee(Player aPlayer) {
        this.aPlayer = aPlayer;
    }

    //==================================================================================
    // PLAY GAME METHOD
    //==================================================================================

    public void playGame() {
        printWelcomeMessage();
        while (playAgain) {
            createBlankScoreSheet();
            printScoreSheet();
            boolean scoreSheetFull = false;
            while (!scoreSheetFull) {
                rollDice();
                printDice();
                rollAgainLoop();
                scoreRoll();
                printScoreSheet();
                scoreSheetFull = checkScoreSheetForCompletion();
            }
            int totalScore = getTotalScore();
            printEndOfGameMessage(totalScore);
            playAgain = userInputYesNoToBoolean(userInputPlayAgain());
        }
    }

    //==================================================================================
    // SCORE SHEET METHODS
    //==================================================================================

    /*
    Check score sheet for completion
     */
    private boolean checkScoreSheetForCompletion() {
        for (Map.Entry<YahtzeeField, Integer> entry : scoreSheet.entrySet()) {
            Integer value = entry.getValue();
            if (value == null) {
                return false;
            }
        }
        return true;
    }

    /*
    Get total score
     */
    private int getTotalScore() {
        int sumOfUpperSection = getUpperSectionScore();
        int bonus = 0;
        if (sumOfUpperSection >= 63) {
            bonus = 35;
        }
        int sumOfLowerSection = getLowerSectionScore();
        return sumOfUpperSection + bonus + sumOfLowerSection;
    }

    /*
    Get upper section score
     */
    private int getUpperSectionScore() {
        int upperScore = 0;
        Iterator it = scoreSheet.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry scoreEntry = (Map.Entry) it.next();
            if (scoreEntry.getKey() == YahtzeeField.ACES || scoreEntry.getKey() == YahtzeeField.TWOS ||
                    scoreEntry.getKey() == YahtzeeField.THREES || scoreEntry.getKey() == YahtzeeField.FOURS ||
                    scoreEntry.getKey() == YahtzeeField.FIVES || scoreEntry.getKey() == YahtzeeField.SIXES) {
                upperScore += (int) (scoreEntry.getValue());
            }
        }
        return upperScore;
    }

    /*
    Get lower section score
     */
    private int getLowerSectionScore() {
        int lowerScore = 0;
        Iterator it = scoreSheet.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry scoreEntry = (Map.Entry) it.next();
            if (scoreEntry.getKey() == YahtzeeField.THREEOFAKIND || scoreEntry.getKey() == YahtzeeField.FOUROFAKIND ||
                    scoreEntry.getKey() == YahtzeeField.FULLHOUSE || scoreEntry.getKey() == YahtzeeField.SMSTRAIGHT ||
                    scoreEntry.getKey() == YahtzeeField.LGSTRAIGHT || scoreEntry.getKey() == YahtzeeField.YAHTZEE ||
                    scoreEntry.getKey() == YahtzeeField.CHANCE) {
                lowerScore += (int) (scoreEntry.getValue());
            }
        }
        return lowerScore;
    }


    //==================================================================================
    // SCORING ROLL METHODS
    //==================================================================================

    /*
    Score roll
     */
    public void scoreRoll() {
        YahtzeeField fieldChoice = chooseYahtzeeField();
        int score = scoreDice(fieldChoice);
        updateScoreSheet(fieldChoice, score);
    }

    /*
    Choose yahtzee field to score
     */
    public YahtzeeField chooseYahtzeeField() {
        String userInput = userInputFieldToScore();
        while (!isValidYahtzeeField(userInput)) {
            printYahtzeeFieldErrorMessage();
            userInput = userInputFieldToScore();
        }
        return YahtzeeField.valueOf(userInput);
    }

    /*
    Check if yahtzee field is valid and free
     */
    public boolean isValidYahtzeeField(String userInput) {
        for (YahtzeeField aYahtzeeField : YahtzeeField.values()) {
            if (aYahtzeeField.toString().equals(userInput)) {
                if (scoreSheet.get(YahtzeeField.valueOf(userInput)) == null) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
    Score dice
    */
    private int scoreDice(YahtzeeField yahtzeeField) {
        setDiceValueCounts();
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
                score = scoreSmStraight(smStraightCriteria());
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
    Score dice "count" fields: aces, twos, threes, fours, fives, or sixes
    */
    public int scoreCountFields(int countField) {
        return diceValueCounts[countField - 1] * countField;
    }

    /*
    Check "of a kind" criteria is met: 3/4 of a kind, chance, yahtzee
    */
    public boolean ofAKindCriteria(int ofAKind) {
        for (int count : diceValueCounts) {
            if (count >= ofAKind) {
                return true;
            }
        }
        return false;
    }

    /*
    Score dice 3/4 of a kind, or chance
    */
    public int scoreOfAKind(boolean meetsOfAKindCriteria) {
        int score = 0;
        if (meetsOfAKindCriteria) {
            for (Die d : dice) {
                score += d.getValue();
            }
        }
        return score;
    }

    /*
    Score yahtzee
     */
    private int scoreYahtzee(boolean meetsOfAKindCriteria) {
        int score = 0;
        if (meetsOfAKindCriteria) {
            score = 50;
        }
        return score;
    }

    /*
    Check Full House criteria is met
    */
    public boolean fullHouseCriteria() {
        int i = 0;
        for (int count : diceValueCounts) {
            if (count >= 2) {
                i++;
            }
        }
        if (i == 2) {
            return true;
        }
        return false;
    }

    /*
    Score Full House
     */
    public int scoreFullHouse(boolean meetsFullHouseCriteria) {
        int score = 0;
        if (meetsFullHouseCriteria) {
            score = 25;
        }
        return score;
    }

    /*
    Check Small Straight criteria is met
    */
    public boolean smStraightCriteria() {
        boolean meetsCriteria = false;
        int i = 0;
        for (int count : diceValueCounts) {
            if (count > 1) {
                i++;
            }
        }
        if (i <= 1) {
            meetsCriteria = true;
        }
        return meetsCriteria;
    }

    /*
    Score SM Straight
     */
    private int scoreSmStraight(boolean meetsSmStraightCriteria) {
        int score = 0;
        if (meetsSmStraightCriteria) {
            score = 30;
        }
        return score;
    }

    /*
    Check Large Straight criteria is met
    */
    public boolean lgStraightCriteria() {
        boolean meetsCriteria = false;
        int i = 0;
        for (int count : diceValueCounts) {
            if (count > 1) {
                i++;
            }
        }
        if (i < 1) {
            meetsCriteria = true;
        }
        return meetsCriteria;
    }

    /*
    Score LG Straight
     */
    public int scoreLgStraight(boolean meetsLgStraightCriteria) {
        int score = 0;
        if (meetsLgStraightCriteria) {
            score = 40;
        }
        return score;
    }

    //==================================================================================
    // ROLLING DICE METHODS
    //==================================================================================

    /*
    Allow the user to roll again up to 2 more times
     */
    public void rollAgainLoop() {
        boolean rollAgain = userInputYesNoToBoolean(userInputRollAgain());
        int rollCounter = 1;
        while (rollAgain) {
            rollAgain();
            printDice();
            rollCounter++;
            if (rollCounter >= 3) {
                break;
            }
            rollAgain = userInputYesNoToBoolean(userInputRollAgain());
        }
    }

    /*
    Roll again
     */
    public void rollAgain() {
        List<Integer> diceToRollAgainList = userInputChooseDice();
        Integer[] diceToRollAgain = turnRollAgainListToArray(diceToRollAgainList);
        rollSelectedDiceAgain(diceToRollAgain);
    }

    /*
    Ask user to select which dice to roll again
     */
    public List<Integer> userInputChooseDice() {
        List<Integer> diceToRollAgainList = new ArrayList<Integer>();
        boolean stillSelecting = true;
        String dicePosition;
        do {
            dicePosition = userInputDiceToRollAgain();
            if (dicePosition.equals("1") || dicePosition.equals("2") || dicePosition.equals("3") ||
                    dicePosition.equals("4") || dicePosition.equals("5")){
                diceToRollAgainList.add(Integer.parseInt(dicePosition));
            } else if (dicePosition.equals("")){
                stillSelecting = false;
            } else {
                printDicePositionErrorMessage();
            }
        } while (stillSelecting);
        return diceToRollAgainList;
    }

    /*
    Turn user input of dice to roll again into an array
     */
    public Integer[] turnRollAgainListToArray(List<Integer> diceToRollAgainList) {
        Integer[] diceToRollAgainArray = null;
        diceToRollAgainArray = diceToRollAgainList.toArray(new Integer[0]);
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

    //==================================================================================
    // Get User Input
    //==================================================================================

    /*
    Ask user if they want to roll again
     */
    public String userInputRollAgain() {
        return aConsole.yesOrNo("Roll again?");
    }

    /*
    Ask user the position of the dice that they want to roll again
     */
    public String userInputDiceToRollAgain() {
     return aConsole.getStringInput("Enter position of dice to roll again or enter to perform roll");
    }

    /*
    Ask user which field they want to score
     */
    public String userInputFieldToScore() {
        return aConsole.getStringInput("Which field do you want to score?").toUpperCase();
    }

    /*
    Ask user if they want to play again
     */
    public String userInputPlayAgain(){
        return aConsole.yesOrNo("Would you like to play again?");
    }

    /*
    Convert user input to boolean
     */
    public boolean userInputYesNoToBoolean(String userInputString) {
        return (userInputString.toUpperCase().equals("YES"));
    }

    //==================================================================================
    // Print Output
    //==================================================================================

    /*
    Print dice
     */
    public void printDice() {
        DrawYahtzeeDice diceDrawer = new DrawYahtzeeDice();
        setDiceValues();
        aConsole.println(diceDrawer.drawYahtzeeDice(diceValues).toString());
        aConsole.println("    1           2           3           4           5    ");
    }

    /*
    Print welcome message
     */
    public void printWelcomeMessage() {
        aConsole.println("Welcome to Yahtzee " + aPlayer.getName());
        printRules();
    }

    /*
    Print rules
    */
    public void printRules() {
        aConsole.println("Roll 5 dice up to 3 times and try to get the highest score");
    }

    /*
    Print score sheet
     */
    private void printScoreSheet() {
        aConsole.println("Scoresheet: " + scoreSheet.toString());
    }

    /*
    Print end of game stats
    */
    public void printEndOfGameMessage(int totalScore) {
        aConsole.println("Game over!");
        aConsole.println("Your total score is: " + totalScore);
    }

    /*
    Print error when yahtzee field input is invalid or already full
     */
    public void printYahtzeeFieldErrorMessage() {
        aConsole.println("please enter valid & free yahtzee field.");
    }

    /*
    Print error when user enters dice to roll outside of 1-5 bounds
     */
    public void printDicePositionErrorMessage() {
        aConsole.println("Enter a number between 1 and 5 or enter to roll");
    }

    //==================================================================================
    // Getters and Setters (and Re-setters)
    //==================================================================================

    /*
    Set dice (roll all dice)
     */
    public void rollDice() {
        dice = diceRoller.rollAll();
    }

    /*
    Get dice
     */
    public Die[] getDice(){
        return this.dice;
    }


    /*
    Set value count array
    */
    public void setDiceValueCounts() {
        resetDiceValueCounts();
        for (Die d : dice) {
            diceValueCounts[d.getValue() - 1]++;
        }
    }

    /*
    Reset count of each value in dice
    */
    public void resetDiceValueCounts() {
        for (int i = 0; i < diceValueCounts.length; i++) {
            diceValueCounts[i] = 0;
        }
    }

    /*
    Get value count array
     */
    public int[] getDiceValueCounts() {
        return this.diceValueCounts;
    }

    /*
    Set dice values array
     */
    public void setDiceValues() {
        for (int i = 0; i < dice.length; i++) {
            diceValues[i] = (dice[i].getValue());
        }
    }

    /*
    Get dice values array
     */
    public int[] getDiceValues() {
        return this.diceValues;
    }

    /*
    Set score sheet with scored value
    */
    public void updateScoreSheet(YahtzeeField yahtzeeField, int score) {
        scoreSheet.put(yahtzeeField, score);
    }

    /*
    Reset score sheet to blank
     */
    public void createBlankScoreSheet() {
        for (YahtzeeField field : YahtzeeField.values()) {
            scoreSheet.put(field, null);
        }
    }

    /*
    Get score sheet
     */
    public Map<YahtzeeField, Integer> getScoreSheet() {
        return this.scoreSheet;
    }
}