package com.example.sheehanmilesk.medquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boozetest = (Button) findViewById(R.id.ciwaar);
        Button cows = (Button) findViewById(R.id.cows);
        Button norton = findViewById(R.id.norton);
        Button braden = findViewById(R.id.braden);
        boozetest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utilityFunctions utilfunc = new utilityFunctions();
                quiz boozequiz = utilfunc.createboozequiz();
                Intent intent = new Intent(MainActivity.this, eightanswerquestion.class);
                intent.putExtra("quiz", boozequiz);
                startActivity(intent);
            }
        });

        cows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utilityFunctions utilfunc = new utilityFunctions();
                quiz cowsquiz = utilfunc.createcows();
                Intent intent = new Intent(MainActivity.this, eightanswerquestion.class);
                intent.putExtra("quiz", cowsquiz);
                startActivity(intent);
            }
        });
        norton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utilityFunctions utilfunc = new utilityFunctions();
                quiz cowsquiz = utilfunc.createNorton();
                Intent intent = new Intent(MainActivity.this, eightanswerquestion.class);
                intent.putExtra("quiz", cowsquiz);
                startActivity(intent);
            }
        });
        braden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utilityFunctions utilfunc = new utilityFunctions();
                quiz cowsquiz = utilfunc.createBraden();
                Intent intent = new Intent(MainActivity.this, eightanswerquestion.class);
                intent.putExtra("quiz", cowsquiz);
                startActivity(intent);
            }
        });
    }
}
