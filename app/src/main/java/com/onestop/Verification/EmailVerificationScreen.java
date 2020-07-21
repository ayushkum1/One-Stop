package com.onestop.Verification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.onestop.R;
import com.onestop.SuccesssfulScreen;

public class EmailVerificationScreen extends AppCompatActivity {

    EditText etOtp1, etOtp2, etOtp3, etOtp4;
    TextView tvResend;
    Button btnVerify;
    String otp1, otp2, otp3, otp4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verification_screen);

        etOtp1 = findViewById(R.id.otp_et_1);
        etOtp2 = findViewById(R.id.otp_et_2);
        etOtp3 = findViewById(R.id.otp_et_3);
        etOtp4 = findViewById(R.id.otp_et_4);

        tvResend = findViewById(R.id.resend_tv);

        btnVerify = findViewById(R.id.verify_button);

        otp1 = etOtp1.getText().toString().trim();
        otp2 = etOtp2.getText().toString().trim();
        otp3 = etOtp3.getText().toString().trim();
        otp4 = etOtp4.getText().toString().trim();

        tvResend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profileIntent = new Intent(EmailVerificationScreen.this, SuccesssfulScreen.class);
                startActivity(profileIntent);
            }
        });
    }
}
