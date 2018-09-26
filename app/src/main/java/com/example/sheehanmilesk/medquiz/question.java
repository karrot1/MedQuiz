package com.example.sheehanmilesk.medquiz;

import java.io.Serializable;

public class question implements Serializable {
    private int answerno;
    private String locstring;
    private int answervalue;
    private String quizname;
    private int[] pointvalues;
    private boolean[] moresevere;
    private boolean desc;
    private boolean setyet;
    public question(int answerNo, String locString, String quizName, boolean[] moreSevere, Boolean Desc, int[] pointValues){
        answerno = answerNo;
        locstring = locString;
        answervalue = -1;
        quizname = quizName;
        moresevere = moreSevere;
        desc = Desc;
        setyet = false;
        if (pointValues == null){
            pointvalues = new int[answerNo];
            int i = 0;
            while (i<answerNo){
                pointvalues[i] = i;
                i++;
            }
        }
        else{
            pointvalues = pointValues;
        }

    }
    public void setSetyet(){
        setyet = true;
    }
    public boolean getSetyet(){
        return setyet;
    }
    public void setAnswervalue(int newValue){
        answervalue = newValue;
    }
    public int getAnswervalue(){
        return answervalue;
    }
    public int getPointvalue(int i){
        return pointvalues[i];
    }
    public int getPointvalue(){
        if (answervalue != -1){
            return pointvalues[answervalue];
        }
        else{
            return -1;
        }
    }
    public boolean[] getMoresevere(){
        return moresevere;
    }
    public String getQuizname(){
        return quizname;
    }
    public String getLocstring(){
        return locstring;
    }
    public int getAnswerno(){
        return answerno;
    }
    public Boolean getDesc(){
        return desc;
    }
}
