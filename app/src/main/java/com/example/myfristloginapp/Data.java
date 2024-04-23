package com.example.myfristloginapp;

import java.util.Date;

public class Data {
    private String Date;
    private int Score;

    public Data() {
    }

    public Data(String date, int score) {
        Date = date;
        Score = score;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        this.Score = score;
    }

}
