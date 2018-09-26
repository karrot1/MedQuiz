package com.example.sheehanmilesk.medquiz;

import android.util.Pair;

import java.io.Serializable;

public class quiz implements Serializable {
    private question[] questions;
    private String quizname;
    private int[] scale;
    private int points;
    private int currentq;
    private utilityFunctions utilfunc;
    public quiz(question[] questionarray, String quizName, int[] quizscale, utilityFunctions givefunc){
        questions = questionarray.clone();
        quizname = quizName;
        scale = quizscale.clone();
        currentq = 0;
        utilfunc = givefunc;
        points = 0;
    }
    public utilityFunctions getUtilfunc(){
        return utilfunc;
    }
    public question[] getQuestions(){
        return questions;
    }
    public String getQuizname(){
        return quizname;
    }
    public int[] getScale(){
        return scale;
    }
    public int getPoints(){
        return points;
    }
    public void setPoints(int newpoints){
        points = newpoints;
    }
    public void addPoints(int addpoints){
        points = points+addpoints;
    }
    public void setCurrentq(int newq){
        currentq = newq;
    }
    public void incCurrentq(){
        currentq = currentq + 1;
    }
    public void decCurrentq(){
        currentq = currentq - 1;
    }
    public int getCurrentq(){
        return currentq;
    }
}
