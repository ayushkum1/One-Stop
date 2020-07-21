package com.onestop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.onestop.Home.HomeScreen;

public class SuccesssfulScreen extends AppCompatActivity {
    TextView tvHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successsful_screen);

        tvHome = findViewById(R.id.home_tv);

        tvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(SuccesssfulScreen.this, HomeScreen.class);
                startActivity(homeIntent);
            }
        });
    }
}
