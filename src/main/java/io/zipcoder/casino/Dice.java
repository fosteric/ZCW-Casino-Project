package io.zipcoder.casino;

public class Dice {

    Die aDie = new Die();
    

    /**
     * Rolls N number of dice
     */
    public int roll(int numberOfDice)
    {
        int rolledDice= 0;

        for(int i = 0; i<numberOfDice; i++)
            rolledDice+= (aDie.rollADice());

        return rolledDice;
    }

}
