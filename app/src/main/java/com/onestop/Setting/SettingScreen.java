package com.onestop.Setting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.onestop.Address.AddressScreen;
import com.onestop.ChooseLanguage.ChooseLanguageScreen;
import com.onestop.Login.LoginScreen;
import com.onestop.UserProfile.ProfileScreen;
import com.onestop.R;

public class SettingScreen extends AppCompatActivity {

    TextView tvTitle;
    ImageButton ibAddress, ibProfile, ibLanguage, ibSignOut, ibBack;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_screen);

        toolbar = findViewById(R.id.toolbar);

        tvTitle = toolbar.findViewById(R.id.title_tv);

        ibBack = findViewById(R.id.back_ib);
        ibAddress = findViewById(R.id.setting_address_ib);
        ibLanguage = findViewById(R.id.setting_language_ib);
        ibProfile = findViewById(R.id.setting_profile_ib);
        ibSignOut = findViewById(R.id.setting_signout_ib);

        tvTitle.setText(R.string.settings);

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        intent(ibAddress, AddressScreen.class);
        intent(ibLanguage, ChooseLanguageScreen.class);
        intent(ibProfile, ProfileScreen.class);
        intent(ibSignOut, LoginScreen.class);
    }

    void intent(ImageButton btn, final Class<? extends Activity> activity){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingScreen.this, activity));
            }
        });
    }
}
