package com.maverick.fight_depression;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistrationActivity extends AppCompatActivity {

    private EditText fullName, email, password, confirmPassword;
    private ProgressBar progressBar;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        fullName = findViewById(R.id.ETfullname);
        email = findViewById(R.id.ETemail);
        password = findViewById(R.id.ETpassword);
        confirmPassword = findViewById(R.id.ETconfirmpassword);
        progressBar = findViewById(R.id.progressbar);
        registerButton = findViewById(R.id.BTNregister);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textFullName = fullName.getText().toString();
                String textEmail = email.getText().toString();
                String textPassword = password.getText().toString();
                String textConfirmPassword = confirmPassword.getText().toString();

                if (TextUtils.isEmpty(textFullName)) {
                    Toast.makeText(RegistrationActivity.this, "Enter Full Name", Toast.LENGTH_SHORT).show();
                    fullName.setError("Full Name Is Required");
                    fullName.requestFocus();
                } else if (TextUtils.isEmpty(textEmail)) {
                    Toast.makeText(RegistrationActivity.this, "Enter Email Address", Toast.LENGTH_SHORT).show();
                    email.setError("Email Is Required");
                    email.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()) {
                    Toast.makeText(RegistrationActivity.this, "Re-enter Email Address", Toast.LENGTH_SHORT).show();
                    email.setError("Enter Valid Email");
                    email.requestFocus();
                } else if (TextUtils.isEmpty(textPassword)) {
                    Toast.makeText(RegistrationActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    password.setError("Password Is Required");
                    password.requestFocus();
                } else if (TextUtils.isEmpty(textConfirmPassword)) {
                    Toast.makeText(RegistrationActivity.this, "Confirm Your Password", Toast.LENGTH_SHORT).show();
                    confirmPassword.setError("Password Is Required");
                    confirmPassword.requestFocus();
                } else if (!textPassword.matches(textConfirmPassword)) {
                    Toast.makeText(RegistrationActivity.this, "Verify Your Password", Toast.LENGTH_SHORT).show();
                    confirmPassword.setError("Password Don't Match");
                    confirmPassword.requestFocus();
                } else {
                    progressBar.setVisibility(View.VISIBLE);

//                    registerUser(textFullName,textEmail,textPassword);
                    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                    firebaseAuth.createUserWithEmailAndPassword(textEmail, textPassword).addOnCompleteListener(
                            new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        progressBar.setVisibility(View.GONE);
                                        Toast.makeText(RegistrationActivity.this, "Registered Succesfully", Toast.LENGTH_SHORT).show();
//                                        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
//                                        firebaseUser.sendEmailVerification();
//                                        Intent intent = new Intent(RegistrationActivity.this, UserProfileActivity.class);
//                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK
//                                                | Intent.FLAG_ACTIVITY_NEW_TASK);
//                                        startActivity(intent);                        }
//                                        finish();
                                    }
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(RegistrationActivity.this, "Registration Failed" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }


            }
        });
    }
}