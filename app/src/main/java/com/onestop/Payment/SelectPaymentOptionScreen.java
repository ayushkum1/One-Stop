package com.onestop.Payment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.onestop.Address.AddAddressScreen;
import com.onestop.Home.MainActivity;
import com.onestop.R;

import java.util.ArrayList;
import java.util.List;

public class SelectPaymentOptionScreen extends AppCompatActivity {

    Spinner spinnerAddressType;
    TextView tvAddress, tvTitle;
    ImageButton ibBack;
    Button btnProceed;
    List<String> addressTypeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_payment_option_screen);

        spinnerAddressType = findViewById(R.id.address_type_spinner);
        tvAddress = findViewById(R.id.address_tv);
        ibBack = findViewById(R.id.back_ib);
        tvTitle = findViewById(R.id.title_tv);
        btnProceed = findViewById(R.id.proceed_payment_btn);

        tvTitle.setText(R.string.payment);
        tvAddress.setText("#108 Surya Vijaya Vihar \n Ganesh Layout Bengaluru 560097 \n Karnataka");

        addressTypeList.add("Home");
        addressTypeList.add("Work");
        addressTypeList.add("Other");

        ArrayAdapter<String> addressTypeAdapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_spinner_item, addressTypeList);
        addressTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAddressType.setAdapter(addressTypeAdapter);
        spinnerAddressType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SelectPaymentOptionScreen.this, "set as "+ parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectPaymentOptionScreen.this, MainActivity.class));
            }
        });
    }
}
