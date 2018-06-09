package io.zipcoder.casino.Leviathan;

public class Player {
    String name;
    Integer totalChips;
    int[] tally = {0,0};
    int age;

    public Player(String name, Integer totalChips, int age){
        this.name = name;
        this.totalChips = totalChips;
        this.age = age;

    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setTotalChips(Integer totalChips){
        this.totalChips = totalChips;
    }

    public Integer getTotalChips(){
        return this.totalChips;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    public Integer getAge(){
        return this.age;
    }

    public void setTally(int[] tally){
        this.tally = tally;
    }

    public int [] getTally(){
        return this.tally;
    }


}
