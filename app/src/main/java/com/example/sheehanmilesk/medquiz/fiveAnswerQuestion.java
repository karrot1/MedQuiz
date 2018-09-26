package com.example.sheehanmilesk.medquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class fiveAnswerQuestion extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.five_answer_question);
        getSupportActionBar().hide();
        final quiz Quiz = (quiz)this.getIntent().getSerializableExtra("quiz");
        final utilityFunctions utilfunc = Quiz.getUtilfunc();
        final TextView question = (TextView) findViewById(R.id.question);
        final TextView questionp2 = (TextView) findViewById(R.id.questionp2);
        final Button[] answerarray = new Button[5];
        answerarray[0] = findViewById(R.id.answer1);
        answerarray[1] = findViewById(R.id.answer2);
        answerarray[2] = findViewById(R.id.answer3);
        answerarray[3] = findViewById(R.id.answer6);
        answerarray[4] = findViewById(R.id.answer7);
        Button backbutton = findViewById(R.id.backbutton);
        Button nextbutton = findViewById(R.id.forwardbutton);
        update_qs(Quiz, answerarray, questionp2, question, utilfunc);
        answerarray[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utilfunc.setAnswer(Quiz, answerarray, 0, getApplicationContext());

            }
        });
        answerarray[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utilfunc.setAnswer(Quiz, answerarray, 1, getApplicationContext());
            }
        });
        answerarray[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utilfunc.setAnswer(Quiz, answerarray, 2, getApplicationContext());
            }
        });
        answerarray[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utilfunc.setAnswer(Quiz, answerarray, 3, getApplicationContext());
            }
        });
        answerarray[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utilfunc.setAnswer(Quiz, answerarray, 4, getApplicationContext());
            }
        });
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Quiz.getQuestions()[Quiz.getCurrentq()].getAnswervalue() == -1){
                    Quiz.getQuestions()[Quiz.getCurrentq()].setAnswervalue(0);
                    }
                    Log.d("updateq", "Updating questionnum");
                    Quiz.incCurrentq();
                    Log.d("updateq", "Changing to question " + Integer.toString(Quiz.getCurrentq()));
                    update_qs(Quiz, answerarray, questionp2, question, utilfunc);

            }
        });
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Quiz.getCurrentq() != 0) {
                    Log.d("updateq", "Updating questionnum");
                    Quiz.decCurrentq();
                    Log.d("updateq", "Changing to question " + Integer.toString(Quiz.getCurrentq()));
                    update_qs(Quiz, answerarray, questionp2, question, utilfunc);
                }
                else{
                    Log.d("updateq", "Questionnum is equal to 0, you can't go back");
                }
            }
        });
    }
    public void update_qs(quiz Quiz, Button[] answerarray, TextView questionp2, TextView question, utilityFunctions utilfunc){
        if (Quiz.getQuestions().length  > Quiz.getCurrentq()){
            Log.d("updateq", "Qs being updated");
            Log.d("updateq", "Answer number is " +Quiz.getQuestions()[Quiz.getCurrentq()].getAnswerno());
            if( Quiz.getQuestions()[Quiz.getCurrentq()].getAnswerno() == 5) {
                Log.d("updateq", "Inside answer = 5");
                String locstring = Quiz.getQuestions()[Quiz.getCurrentq()].getLocstring();
                if (Quiz.getQuestions()[Quiz.getCurrentq()].getDesc()) {
                    Log.d("updateq", "inside setting desc");
                    questionp2.setText(getResources().getString(getResources().getIdentifier(locstring + "p2", "string", getPackageName())));
                } else {
                    Log.d("updateq", "setting empty desc");
                    questionp2.setText("");
                }
                Log.d("updateq", "setting question text");
                question.setText(getResources().getString(getResources().getIdentifier(locstring, "string", getPackageName())));
                int i = 0;
                Log.d("updateq", "Qs being updated");
                int pointvalue = Quiz.getQuestions()[Quiz.getCurrentq()].getAnswervalue();
                while (i < answerarray.length) {
                    if (pointvalue == i) {
                        utilfunc.setAnswerText( i,null,  answerarray, true, getApplicationContext(), false, 0, Quiz.getQuestions()[Quiz.getCurrentq()]);
                    } else {
                        utilfunc.setAnswerText( i,null,  answerarray, false, getApplicationContext(), false, 0, Quiz.getQuestions()[Quiz.getCurrentq()]);
                    }
                    i++;
                }
            }
            else if (Quiz.getQuestions()[Quiz.getCurrentq()].getAnswerno() == 8){
                Log.d("updateq", "loading eight answer q");
                Intent intent = new Intent(fiveAnswerQuestion.this, eightanswerquestion.class);
                intent.putExtra("quiz", Quiz);
                startActivity(intent);
            }
            else if (Quiz.getQuestions()[Quiz.getCurrentq()].getAnswerno() == 4){
                Log.d("updateq", "loading 4 answer q");
                Intent intent = new Intent(fiveAnswerQuestion.this, fouranswerquestion.class);
                intent.putExtra("quiz", Quiz);
                startActivity(intent);
            }
            else if (Quiz.getQuestions()[Quiz.getCurrentq()].getAnswerno() == 3){
                Log.d("updateq", "loading 4 answer q");
                Intent intent = new Intent(fiveAnswerQuestion.this, threeAnswerQuestion.class);
                intent.putExtra("quiz", Quiz);
                startActivity(intent);
            }
        }
        else{

            Log.d("final", "loading final thing");
            if (Quiz.getQuestions().length == 10){
                Intent intent = new Intent(fiveAnswerQuestion.this, resultScreen.class);
                intent.putExtra("quiz", Quiz);
                startActivity(intent);
            }
            else if (Quiz.getQuestions().length == 11){
                Intent intent = new Intent(fiveAnswerQuestion.this, elevenresultScreen.class);
                intent.putExtra("quiz", Quiz);
                startActivity(intent);
            }
        }
    }
}