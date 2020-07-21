package com.onestop.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.onestop.Home.HomeScreen;
import com.onestop.R;
import com.onestop.SignUp.SignupScreen;

public class LoginScreen extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnLogin;
    ImageButton ibSignUp, ibGoogleSignIn, ibFBSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        etEmail = findViewById(R.id.email_et);
        etPassword = findViewById(R.id.password_et);

        btnLogin = findViewById(R.id.login_btn);

        ibSignUp = findViewById(R.id.signup_ib);
        ibGoogleSignIn = findViewById(R.id.google_signin_ib);
        ibFBSignIn = findViewById(R.id.fb_signin_ib);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginScreen.this, HomeScreen.class));
            }
        });

        ibSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginScreen.this, SignupScreen.class));
            }
        });

        ibGoogleSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginScreen.this, "Google Login", Toast.LENGTH_SHORT).show();
            }
        });

        ibFBSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginScreen.this, "FB Login", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
