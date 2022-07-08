package com.maverick.fight_depression;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class FoodActivity extends AppCompatActivity {

    private static final long startTime = 600000;
    private TextView TextViewCountDown;
    private Button Start, Skip, Reset;

    private CountDownTimer countDownTimer;
    private boolean timerRunning;
    private long timeLeft = startTime;
    private String passString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        Intent i = getIntent();
        passString = i.getStringExtra("Activity");

        TextViewCountDown = findViewById(R.id.idActivityFoodTIMER);
        Start = findViewById(R.id.idActivityFoodStart);
        Skip = findViewById(R.id.idActivityFoodSkip);
        Reset = findViewById(R.id.idActivityFoodReset);
        Skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(passString.equals("depress")){
                    Intent i = new Intent(FoodActivity.this, hobbyActivity.class);
                    i.putExtra("Activity","depress");
                    startActivity(i);
                }else if(passString.equals("happy")){
                    Intent i = new Intent(FoodActivity.this, hobbyActivity.class);
                    i.putExtra("Activity","happy");
                    startActivity(i);
                }

            }
        });

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(timerRunning){
                    pauseTimer();
                }else{
                    startTimer();
                }
            }
        });

        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });

        updateCountDownText();
    }

    private void startTimer(){
        countDownTimer = new CountDownTimer(timeLeft,1000) {
            @Override
            public void onTick(long l) {
                timeLeft = l;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                if(passString.equals("depress")){
                    Intent i = new Intent(FoodActivity.this, hobbyActivity.class);
                    i.putExtra("Activity","depress");
                    startActivity(i);
                }else if(passString.equals("happy")){
                    Intent i = new Intent(FoodActivity.this, hobbyActivity.class);
                    i.putExtra("Activity","happy");
                    startActivity(i);
                }
            }
        }.start();

        timerRunning = true;
        Start.setText("Pause");
        Reset.setVisibility(View.VISIBLE);
    }

    private void pauseTimer(){
        countDownTimer.cancel();
        timerRunning = false;
        Start.setText("Start");
    }

    private void resetTimer(){
        timeLeft = startTime;
        updateCountDownText();

    }

    private void updateCountDownText(){
        int minutes = (int) (timeLeft/1000)/60;
        int seconds = (int) (timeLeft/1000)%60;

        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        TextViewCountDown.setText(timeLeftFormatted);
    }
}