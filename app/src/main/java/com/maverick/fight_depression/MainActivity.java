package com.maverick.fight_depression;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button registerButton;
    private TextView loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Fight Depression");
        registerButton = findViewById(R.id.idActivityMainBtnRegister);
        loginButton = findViewById(R.id.idActivityMainLoginBtn);
        
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Intent Register", Toast.LENGTH_SHORT).show();
            }
        });
        
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Login Intent", Toast.LENGTH_SHORT).show();
            }
        });
    }

}