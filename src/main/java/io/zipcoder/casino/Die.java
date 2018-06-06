package io.zipcoder.casino;

public class Die {
    int value;

    public void setValue(){
    }

    public int getValue(){
        return value;

    }

    public  int rollADice() {
        int rolled = (int)(Math.random()* 6)+ 1;
        return value = rolled;
    }

}
