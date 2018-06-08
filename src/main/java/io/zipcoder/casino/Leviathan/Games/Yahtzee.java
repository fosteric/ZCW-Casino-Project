package io.zipcoder.casino.Leviathan.Games;
import io.zipcoder.casino.Leviathan.Games.GameUtilities.*;
import io.zipcoder.casino.Leviathan.*;
import java.util.*;


public class Yahtzee extends DiceGame {

    Console console = new Console();
    Map<YahtzeeField, Integer> scoreSheet = new HashMap<YahtzeeField, Integer>();
    Dice diceRoller;
    Die[] dice;
    Player aPlayer;

    public Yahtzee(Player aPlayer) {
        this.aPlayer = aPlayer;
        diceRoller = new Dice(5);
        dice = diceRoller.rollAll();
    }

    public boolean playGame() {
        dice = diceRoller.rollAll();
        displayDice();
        boolean rollAgain = chooseToRollAgain();
        if (rollAgain) {
            getSelectDiceToKeep();
            rollUnselectedDice();
        } else {
            YahtzeeField fieldChoice = chooseYahtzeeField();
            scoreDice(fieldChoice);
        }
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

    public void displayDice() {
        StringBuilder currentDice = new StringBuilder();
        for (int i = 0; i < dice.length; i++) {
            currentDice.append(dice[i].getValue());
            if (i < dice.length - 1) {
                currentDice.append(", ");
            }
        }
        console.println("current roll: " + currentDice.toString());
    }

    public boolean chooseToRollAgain() {
        String rollAgain = aConsole.getStringInput
                ("Roll again or score dice?").toUpperCase();
        boolean rollAgainChoice;
        if (rollAgain.equals("ROLL AGAIN")) {
            rollAgainChoice = true;
        } else {
            rollAgainChoice = false;
        }
        return rollAgainChoice;
    }

    public int[] getSelectDiceToKeep(){
        int [] dicePositionsToKeep = null;
        ArrayList<Integer> dicePositionsToKeepList = new ArrayList<Integer>();
        boolean stillSelecting = true;
        while (stillSelecting) {
            Integer positionOfDiceToKeep = aConsole.getIntInput
                    ("Enter position of dice to keep or 0 to perform roll");
            dicePositionsToKeepList.add(positionOfDiceToKeep);
        }
        return dicePositionsToKeep;
    }

    public void rollUnselectedDice(int... diePosition) {
        for (int i = 0; i < diePosition.length; i++) {
            dice[diePosition[i]].rollADice();
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
