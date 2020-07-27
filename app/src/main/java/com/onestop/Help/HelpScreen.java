package com.onestop.Help;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.onestop.R;

public class HelpScreen extends AppCompatActivity {

    TextView tvTitle;
    ImageView ivCall, ivMail, ivMessage;
    ImageButton ibBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_screen);

        tvTitle = findViewById(R.id.title_tv);

        ibBack = findViewById(R.id.back_ib);

        ivCall = findViewById(R.id.call_image);
        ivMail = findViewById(R.id.email_image);
        ivMessage = findViewById(R.id.message_image);

        tvTitle.setText(R.string.help);

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HelpScreen.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        ivMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HelpScreen.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        ivMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HelpScreen.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
