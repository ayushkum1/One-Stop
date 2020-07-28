package com.onestop.UserProfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.onestop.Home.MainActivity;
import com.onestop.R;

public class EditProfileScreen extends AppCompatActivity {

    TextView tvHeading, tvName, tvTitle;
    EditText etFieldName;
    Button btnNext;
    ImageButton ibBack;

    String fieldname, customerfield;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_screen);

        tvHeading = findViewById(R.id.header_tv);
        tvName = findViewById(R.id.field_name_tv);
        etFieldName = findViewById(R.id.field_et);
        btnNext = findViewById(R.id.next_btn);

        tvTitle = findViewById(R.id.title_tv);
        ibBack = findViewById(R.id.back_ib);

        tvTitle.setText(R.string.edit_profile);

        Intent editIntent = getIntent();
        fieldname = editIntent.getStringExtra("fieldnameTV");
        customerfield = editIntent.getStringExtra("fieldTV");

        final String headingname = "Edit " + fieldname; //cant concatenate in textview

        tvHeading.setText(headingname);
        tvName.setText(fieldname);
        etFieldName.setHint(customerfield);

        if(fieldname.equals("First Name") || fieldname.equals("Last Name")){
            btnNext.setText(getResources().getString(R.string.save));
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent homeIntent = new Intent(EditProfileScreen.this, MainActivity.class);
                    startActivity(homeIntent);
                    Toast.makeText(EditProfileScreen.this, "Data Saved", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else{
            btnNext.setText(getResources().getString(R.string.next));
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent verifyIntent = new Intent(EditProfileScreen.this, VerifyScreen.class);
                    verifyIntent.putExtra("headingTV", headingname);
                    verifyIntent.putExtra("fieldnameTV", fieldname);
                    verifyIntent.putExtra("fieldTV", customerfield);
                    startActivity(verifyIntent);
                }
            });
        }

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
