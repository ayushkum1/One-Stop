package com.onestop.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.onestop.Home.HomeScreen;
import com.onestop.Home.MainActivity;
import com.onestop.R;

public class VerifyScreen extends AppCompatActivity {

    TextView tvHeading, tvName;
    EditText etFieldName, etFieldVerification;
    Button btnNext;

    String fieldname, customerfield, headingname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_screen);

        tvHeading = findViewById(R.id.header_tv);
        tvName = findViewById(R.id.field_name_tv);
        etFieldName = findViewById(R.id.field_et);
        etFieldVerification = findViewById(R.id.field_verification_et);
        btnNext = findViewById(R.id.next_btn);

        Intent editIntent = getIntent();
        headingname = editIntent.getStringExtra("headingTV");
        fieldname = editIntent.getStringExtra("fieldnameTV");
        customerfield = editIntent.getStringExtra("fieldTV");

        tvHeading.setText(headingname);
        tvName.setText(fieldname);
        etFieldName.setHint(customerfield);
        btnNext.setText(getResources().getString(R.string.done));

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(VerifyScreen.this, MainActivity.class);
                startActivity(homeIntent);
                Toast.makeText(VerifyScreen.this, "Verified", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
