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

    public boolean playGame() {

        //roll all dice
        dice = diceRoller.rollAll();
        //display dice
        displayDice();

        //ask user if they want to roll again
        boolean rollAgain = userInputRollAgain();
        //if they want to roll again
        if (rollAgain) {
            //select the dice to keep
            Integer[] diceToRollAgain = userInputDiceToRollAgain();
            //roll remaining dice
            rollSelectedDiceAgain(diceToRollAgain);
            displayDice();
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

    public boolean userInputRollAgain() {
        String rollAgainInput = aConsole.getStringInput
                ("Roll again?").toUpperCase();
        boolean rollAgain;
        if (rollAgainInput.equals("YES")) {
            rollAgain = true;
        } else {
            rollAgain = false;
        }
        return rollAgain;
    }

    public Integer[] userInputDiceToRollAgain(){
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


    public void rollSelectedDiceAgain(Integer... diceToRollAgain) {
        for (Integer position : diceToRollAgain) {
            dice[diceToRollAgain[position]].rollADice();
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
