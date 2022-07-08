package com.maverick.fight_depression;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class enquireActivity extends AppCompatActivity {

    private ImageView IVdepressed, IVhappy, IVfeared, IVangry, IVdisgusted, IVsurprised;
    private TextView TVdepressed, TVhappy, TVfeared, TVangry, TVdisgusted, TVsurprised;
    private LinearLayout LLdepressed, LLhappy, LLfeared, LLangry, LLdisgusted, LLsurprised;
    private String passString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquire);
        initialize();

        //Depressed
        IVdepressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDepressedActivity();
            }
        });
        TVdepressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDepressedActivity();
            }
        });
        LLdepressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDepressedActivity();
            }
        });

        //Happy
        IVhappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startHappyActivity();
            }
        });
        TVhappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startHappyActivity();
            }
        });
        LLhappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startHappyActivity();
            }
        });

        //Fear
        IVfeared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFearActivity();
            }
        });
        TVfeared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFearActivity();
            }
        });
        LLfeared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFearActivity();
            }
        });

        //Angry
        IVangry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAngryActivity();
            }
        });
        TVangry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAngryActivity();
            }
        });
        LLangry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAngryActivity();
            }
        });

        //Disgust
        IVdisgusted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDisgustActivity();
            }
        });
        TVdisgusted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDisgustActivity();
            }
        });
        LLdisgusted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDisgustActivity();
            }
        });
        //Surprise
        IVsurprised.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSurpriseActivity();
            }
        });
        TVsurprised.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSurpriseActivity();
            }
        });
        LLsurprised.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSurpriseActivity();
            }
        });
    }

    //depressed
    private void startDepressedActivity(){
        Intent i = new Intent(enquireActivity.this,physicalActivity.class);
        i.putExtra("Activity","depress");
        startActivity(i);
    }
    //happy
    private void startHappyActivity(){
        Intent i = new Intent(enquireActivity.this,FamilyActivity.class);
        i.putExtra("Activity","happy");
        startActivity(i);
    }
    //feared
    private void startFearActivity(){
        Intent i = new Intent(enquireActivity.this,physicalActivity.class);
        i.putExtra("Activity","fear");
        startActivity(i);
    }
    //angry
    private void startAngryActivity(){
        Intent i = new Intent(enquireActivity.this,BreatheActivity.class);
        i.putExtra("Activity","angry");
        startActivity(i);
    }
    //disgusted
    private void startDisgustActivity(){
        Intent i = new Intent(enquireActivity.this,BreatheActivity.class);
        i.putExtra("Activity","fear");
        startActivity(i);
    }
    //surprised
    private void startSurpriseActivity(){
        Intent i = new Intent(enquireActivity.this,FamilyActivity.class);
        i.putExtra("Activity","surprise");
        startActivity(i);
    }

    private void initialize(){
        IVdepressed = findViewById(R.id.idActivityEnquireDepressedLogo);
        IVhappy = findViewById(R.id.idActivityEnquireHappyLogo);
        IVfeared = findViewById(R.id.idActivityEnquireFearLogo);
        IVangry = findViewById(R.id.idActivityEnquireAngryLogo);
        IVdisgusted = findViewById(R.id.idActivityEnquireDisgustLogo);
        IVsurprised = findViewById(R.id.idActivityEnquireSurprisedLogo);

        TVdepressed = findViewById(R.id.idActivityEnquireTextViewDepressed);
        TVhappy = findViewById(R.id.idActivityEnquireHappyText);
        TVfeared = findViewById(R.id.idActivityEnquireTextViewFeared);
        TVangry = findViewById(R.id.idActivityEnquireAngryText);
        TVdisgusted = findViewById(R.id.idActivityEnquireTextViewDisgust);
        TVsurprised = findViewById(R.id.idActivityEnquireSurprisedText);

        LLdepressed = findViewById(R.id.idLLdepressed);
        LLhappy = findViewById(R.id.idLLhappy);
        LLfeared = findViewById(R.id.idLLfeared);
        LLangry = findViewById(R.id.idLLangry);
        LLdisgusted = findViewById(R.id.idLLdisgusted);
        LLsurprised = findViewById(R.id.idLLsurprised);
    }
}