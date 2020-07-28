package com.onestop.UserProfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.onestop.R;

public class ProfileScreen extends AppCompatActivity {

    TextView tvFname, tvLname, tvPhoneNo, tvEmail, tvProfilePicture, tvTitle;

    ImageButton ibFname, ibLname, ibPhone, ibProfilePicture, ibBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);

        tvFname = findViewById(R.id.fname_tv);
        tvLname = findViewById(R.id.lname_tv);
        tvPhoneNo = findViewById(R.id.phone_no_tv);
        tvEmail = findViewById(R.id.email_tv);
        tvProfilePicture = findViewById(R.id.profile_picture_tv);
        tvTitle = findViewById(R.id.title_tv);

        ibFname = findViewById(R.id.fname_btn);
        ibLname = findViewById(R.id.lname_btn);
        ibPhone = findViewById(R.id.phone_btn);
        ibProfilePicture = findViewById(R.id.profile_picture_btn);
        ibBack = findViewById(R.id.back_ib);

        tvTitle.setText(R.string.profile);

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        intent(ibFname, "First Name", "Customer First Name");
        intent(ibLname, "Last Name", "Customer Last Name");
        intent(ibPhone, "Phone", getResources().getString(R.string.example_phoneNo));
        intent(ibProfilePicture, "Profile Picture", getResources().getString(R.string.example_profile_pic));

    }

    //function for all the button clicks
    public void intent(ImageButton btn, final String fieldname, final String field){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editFieldIntent = new Intent(ProfileScreen.this, EditProfileScreen.class);
                editFieldIntent.putExtra("fieldnameTV", fieldname);
                editFieldIntent.putExtra("fieldTV", field);
                startActivity(editFieldIntent);
            }
        });
    }
}
