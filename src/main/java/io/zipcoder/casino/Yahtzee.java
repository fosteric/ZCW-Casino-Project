package io.zipcoder.casino;
import java.util.ArrayList;

public class Yahtzee extends DiceGame {

    Console console = new Console();
    Dice dice = new Dice();
    Die[] currentDiceRoll;

    public boolean playGame(Player aPlayer) {
        //roll dice (1)
            //roll all 5 dice
            currentDiceRoll = dice.roll(5);
        //Use roll or roll again?
            //If roll again, select which dice to keep
                //roll remaining dice (2)
            ArrayList<Dice> additionalDiceRoll1 =
            //If use roll, select a field
        //Use roll or roll again?
            //If roll again, select which dice to keep
                //roll remaining dice (3)
            //If use roll, select a field
        //Select a field
        return false;
    }

    public Die[] rollAgain(int numberOfDice){
        console.
        Die[] additionalDiceRoll;
        additionalDiceRoll = dice.roll(numberOfDice);

    }

}
