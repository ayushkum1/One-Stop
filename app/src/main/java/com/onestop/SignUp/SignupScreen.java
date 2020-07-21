package com.onestop.SignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.onestop.R;
import com.onestop.Verification.EmailVerificationScreen;

//user should be sent to verification, only for email here. in profile can verify number and email

public class SignupScreen extends AppCompatActivity {

    EditText etFname, etLname, etEmail, etPhone;
    Button btnVerify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);

        etFname = findViewById(R.id.fname_et);
        etLname = findViewById(R.id.lname_et);
        etEmail = findViewById(R.id.email_et);
        etPhone = findViewById(R.id.phone_number_et);

        btnVerify = findViewById(R.id.verify_btn);

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupScreen.this, EmailVerificationScreen.class));
            }
        });
    }
}
