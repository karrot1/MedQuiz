package com.example.sheehanmilesk.medquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class elevenresultScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eleven_result_screen);
        getSupportActionBar().hide();
        final quiz Quiz = (quiz)this.getIntent().getSerializableExtra("quiz");
        final TextView results = (TextView) findViewById(R.id.results);
        final TextView total = (TextView) findViewById(R.id.total);
        final Button[] questionarray = new Button[11];
        questionarray[0] = findViewById(R.id.question1);
        questionarray[1] = findViewById(R.id.question2);
        questionarray[2] = findViewById(R.id.question3);
        questionarray[3] = findViewById(R.id.question4);
        questionarray[4] = findViewById(R.id.question5);
        questionarray[5] = findViewById(R.id.question6);
        questionarray[6] = findViewById(R.id.question7);
        questionarray[7] = findViewById(R.id.question8);
        questionarray[8] = findViewById(R.id.question9);
        questionarray[9] = findViewById(R.id.question10);
        questionarray[10] = findViewById(R.id.question11);
        Button again = findViewById(R.id.again);
        Button diftest = findViewById(R.id.diftest);
        int i = 0;
        int questionpoints = 0;
        int totalpoints = Quiz.getPoints();
        int[] scale = Quiz.getScale();
        total.setText(getResources().getString(R.string.totalpoints, totalpoints));
        i = 0;
        while (i < scale.length){
            if (scale[i] > totalpoints){
                Log.d("results", Quiz.getQuizname() + Integer.toString(i+1));
                results.setText(getResources().getString(getResources().getIdentifier(Quiz.getQuizname() + Integer.toString(i+1), "string", getPackageName())));
                break;
            }
            i++;
        }
        i = 0;
        while (i < questionarray.length){
            questionpoints = Quiz.getQuestions()[i].getAnswervalue();
            Log.d("updateq", Quiz.getQuizname() + Integer.toString(i+1) + Integer.toString(questionpoints));
            Quiz.getUtilfunc().setAnswerText(i, Quiz.getQuizname() + "q" + Integer.toString(i+1), questionarray, false, getApplicationContext(), true, questionpoints, Quiz.getQuestions()[i]);
            i++;
        }
        questionarray[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quiz.setCurrentq(0);
                updateqs(Quiz);
            }
        });
        questionarray[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quiz.setCurrentq(1);
                updateqs(Quiz);
            }
        });
        questionarray[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quiz.setCurrentq(3);
                updateqs(Quiz);
            }
        });
        questionarray[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quiz.setCurrentq(4);
                updateqs(Quiz);
            }
        });
        questionarray[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quiz.setCurrentq(5);
                updateqs(Quiz);
            }
        });
        questionarray[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quiz.setCurrentq(6);
                updateqs(Quiz);
            }
        });
        questionarray[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quiz.setCurrentq(7);
                updateqs(Quiz);
            }
        });
        questionarray[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quiz.setCurrentq(8);
                updateqs(Quiz);
            }
        });
        questionarray[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quiz.setCurrentq(3);
                updateqs(Quiz);
            }
        });
        questionarray[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quiz.setCurrentq(9);
                updateqs(Quiz);
            }
        });
        questionarray[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quiz.setCurrentq(10);
                updateqs(Quiz);
            }
        });
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Quiz.getQuizname().equals("ciwaar")) {
                    quiz quiz = Quiz.getUtilfunc().createboozequiz();
                    Intent intent = new Intent(elevenresultScreen.this, eightanswerquestion.class);
                    intent.putExtra("quiz", quiz);
                    startActivity(intent);
                }
                else if (Quiz.getQuizname().equals("cows")) {
                    quiz quiz = Quiz.getUtilfunc().createcows();
                    Intent intent = new Intent(elevenresultScreen.this, fouranswerquestion.class);
                    intent.putExtra("quiz", quiz);
                    startActivity(intent);
                }
            }
        });
        diftest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(elevenresultScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void updateqs(quiz Quiz){
        if (Quiz.getQuestions()[Quiz.getCurrentq()].getAnswerno() == 8) {
            Log.d("updateq", "loading eight answer q");
            Intent intent = new Intent(elevenresultScreen.this, eightanswerquestion.class);
            intent.putExtra("quiz", Quiz);
            startActivity(intent);
        }
        else if (Quiz.getQuestions()[Quiz.getCurrentq()].getAnswerno() == 5) {
            Log.d("updateq", "loading five answer q");
            Intent intent = new Intent(elevenresultScreen.this, fiveAnswerQuestion.class);
            intent.putExtra("quiz", Quiz);
            startActivity(intent);
        }
    }
}