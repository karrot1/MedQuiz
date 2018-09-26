package com.example.sheehanmilesk.medquiz;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.Log;
import android.widget.Button;

import java.io.Serializable;

public class utilityFunctions implements Serializable{

    private final boolean[] moresevere = {false, false, true, true, false, true, true, false};
    private final boolean[] nosevere = {false, false, false, false, false, false, false, false};
    private final boolean[] fivenosevere = {false, false, false, false, false};
    private final boolean[] fournosevere = {false, false, false, false};
    private final boolean[] threenosevere = {false, false, false};
    public utilityFunctions(){

    }
    public void setAnswerText(int i, String locstring, Button[] answerarray, Boolean selected, Context context, boolean finali, int otheri, question thequestion){
        if (locstring == null){
            locstring = thequestion.getLocstring();
        }
        boolean moresev;
        if (!finali){
            moresev = thequestion.getMoresevere()[i];
        }
        else{
            moresev = thequestion.getMoresevere()[otheri];
        }
        String answertext = "";
        if (!moresev) {
            if (!finali) {
                Log.d("updateq", "Locstring is " + locstring + "a" + Integer.toString(i));
                answertext = context.getResources().getString(context.getResources().getIdentifier(locstring + "a" + Integer.toString(i), "string", context.getPackageName()), thequestion.getPointvalue(i));
            }
            else{
                Log.d("updateq", "Locstring is " + locstring + "a" + Integer.toString(otheri));
                answertext = context.getResources().getString(context.getResources().getIdentifier(locstring + "a" + Integer.toString(otheri), "string", context.getPackageName()), otheri);
            }
        } else {
            if (!finali){
                answertext = context.getResources().getString(R.string.moresevere, thequestion.getPointvalue(i));
            }
            else{
                answertext = context.getResources().getString(R.string.moresevere, otheri);
            }
        }
        if (selected){
            SpannableString spanString = new SpannableString(answertext);
            spanString.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString.length(), 0);
            answerarray[i].setBackgroundColor(Color.WHITE);
            answerarray[i].setText(spanString);
        }
        else{
            answerarray[i].setBackgroundResource(android.R.drawable.btn_default);
            answerarray[i].setText(answertext);
        }
    }
    public void setAnswer(quiz Quiz, Button[] answerarray, int newvalue, Context context){
        Quiz.addPoints(Quiz.getQuestions()[Quiz.getCurrentq()].getPointvalue(newvalue));
        int i = Quiz.getQuestions()[Quiz.getCurrentq()].getPointvalue();
        if (i != -1) {
            Quiz.addPoints(i*-1);
            setAnswerText( i, null, answerarray, false, context, false, 0, Quiz.getQuestions()[Quiz.getCurrentq()]);
        }
        Quiz.getQuestions()[Quiz.getCurrentq()].setAnswervalue(newvalue);
        setAnswerText( newvalue, null, answerarray, true, context, false, 0, Quiz.getQuestions()[Quiz.getCurrentq()]);
    }
    public quiz createboozequiz(){

        String quizname = "ciwaar";
        int[] scale = new int[4];
        scale[0] = 9;
        scale[1] = 15;
        scale[2] = 20;
        scale[3] = 67;
        question[] questionarray = new question[10];
        questionarray[0] = new question(8, "ciwaarq1", quizname, moresevere, true, null);
        questionarray[1] = new question(8, "ciwaarq2", quizname, moresevere, true, null);
        questionarray[2] = new question(8, "ciwaarq3", quizname, moresevere, false, null);
        questionarray[3] = new question(8, "ciwaarq4", quizname, moresevere, true, null);
        questionarray[4] = new question(8, "ciwaarq5", quizname, moresevere, false, null);
        questionarray[5] = new question(8, "ciwaarq6", quizname, nosevere, true, null);
        questionarray[6] = new question(8, "ciwaarq7", quizname, nosevere, true, null);
        questionarray[7] = new question(8, "ciwaarq8", quizname, nosevere, true, null);
        questionarray[8] = new question(8, "ciwaarq9", quizname, nosevere, true, null);
        questionarray[9] = new question(5, "ciwaarq10", quizname, fivenosevere, true, null);
        quiz boozequiz = new quiz(questionarray, quizname, scale, this);
        return boozequiz;
    }
    public quiz createcows(){
        String quizname = "cows";
        int[] scale = new int[5];
        scale[0] = 5;
        scale[1] = 12;
        scale[2] = 24;
        scale[3] = 36;
        scale[4] = 100;
        int[] zero124 = new int[]{0,1, 2, 4};
        int[] zero135 = new int[]{0, 1, 3, 5};
        int[] zero125 = new int[]{0, 1, 2, 5};
        int[] zero1235 = new int[]{0, 1, 2, 3, 5};
        int[] zero35 = new int[]{0, 3, 5};
        question[] questionarray = new question[11];
        questionarray[0] = new question(4, "cowsq1", quizname, fournosevere, true, zero124);
        questionarray[1] = new question(5, "cowsq2", quizname, fivenosevere, true, null);
        questionarray[2] = new question(4, "cowsq3", quizname, fournosevere, false, zero135);
        questionarray[3] = new question(4, "cowsq4", quizname, fournosevere, false, zero125);
        questionarray[4] = new question(4, "cowsq5", quizname, fournosevere, true, zero124);
        questionarray[5] = new question(4, "cowsq6", quizname, fournosevere, true, zero124);
        questionarray[6] = new question(5, "cowsq7", quizname, fivenosevere, true, zero1235);
        questionarray[7] = new question(4, "cowsq8", quizname, fournosevere, false, zero124);
        questionarray[8] = new question(4, "cowsq9", quizname, fournosevere, false, zero124);
        questionarray[9] = new question(4, "cowsq10", quizname, fournosevere, false, zero124);
        questionarray[10] = new question(3, "cowsq11", quizname, threenosevere, false, zero35);
        quiz cowsquiz = new quiz(questionarray, quizname, scale, this);
        return cowsquiz;
    }

}
