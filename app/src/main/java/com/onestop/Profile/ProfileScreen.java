package com.onestop.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.onestop.R;

public class ProfileScreen extends AppCompatActivity {

    TextView tvFname, tvLname, tvPhoneNo, tvEmail, tvProfilePicture;

    ImageButton btnFname, btnLname, btnPhone, btnProfilePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);

        tvFname = findViewById(R.id.fname_tv);
        tvLname = findViewById(R.id.lname_tv);
        tvPhoneNo = findViewById(R.id.phone_no_tv);
        tvEmail = findViewById(R.id.email_tv);
        tvProfilePicture = findViewById(R.id.profile_picture_tv);

        btnFname = findViewById(R.id.fname_btn);
        btnLname = findViewById(R.id.lname_btn);
        btnPhone = findViewById(R.id.phone_btn);
        btnProfilePicture = findViewById(R.id.profile_picture_btn);

        intent(btnFname, "First Name", "Customer First Name");
        intent(btnLname, "Last Name", "Customer Last Name");
        intent(btnPhone, "Phone", getResources().getString(R.string.example_phoneNo));
        intent(btnProfilePicture, "Profile Picture", getResources().getString(R.string.example_profile_pic));

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
