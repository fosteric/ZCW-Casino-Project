package io.zipcoder.casino;

public class Player {
    String name;
    Integer totalChips;

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

}
