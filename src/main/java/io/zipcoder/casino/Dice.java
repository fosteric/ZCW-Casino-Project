package io.zipcoder.casino;

public class Dice {
    Die[] dice;

    public Dice(int numberOfDice) {


     dice = new Die[numberOfDice];
     for (int i = 0; i < dice.length; i++){
         dice[i] = new Die();
     }
}

    public Die[] getDice(){
        return dice;
    }

    public Die[] rollAll() {


        for (int i = 0; i < dice.length; i++){
             dice[i].rollADice();

        }
        return dice;
    }



}
