package com.example.hiittrainingapp;

import java.io.Serializable;

public class WorkOutPart implements Serializable {

    private int seconds;
    private String name;

    public WorkOutPart(int seconds, String name) {
        this.seconds = seconds;
        this.name = name;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
