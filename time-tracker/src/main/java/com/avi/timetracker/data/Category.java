package com.avi.timetracker.data;

public class Category {

    public static final String NONE = "no-category";

    private String name;
    private int totalTime;

    public Category(){

    }
    
    public Category(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
    public int getTotalTime() {
        return totalTime;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    
}
