package io.zipcoder.casino.Leviathan;

public class Player {
    String name;
    Integer totalChips;
    int[] tally = {0, 0};
    int age;

    public Player(String name, Integer totalChips, int age) {
        this.name = name;
        this.totalChips = totalChips;
        this.age = age;

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalChips() {
        return this.totalChips;
    }

    public void setTotalChips(Integer totalChips) {
        this.totalChips = totalChips;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int[] getTally() {
        return this.tally;
    }

    public void setTally(int[] tally) {
        this.tally = tally;
    }


}
