package com.maverick.fight_depression;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    private String passString;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        textView = findViewById(R.id.idActivityFinalLogoText3);
        Intent i = getIntent();
        passString = i.getExtras().getString("Activity");
        textView.setText("Hope we have helped you with " + passString + " emotion");
    }
}