package com.example.workout.model;

import java.io.Serializable;


public class Type implements Serializable {

    private String type;
    private int seconds;


    public String getType(){
        return type;
    }


    public void setType(String settype) {
        type = settype;
    }


    public int getSeconds(){
        return seconds;
    }


    public void setSeconds(int setseconds) {
        seconds = setseconds;
    }

}
