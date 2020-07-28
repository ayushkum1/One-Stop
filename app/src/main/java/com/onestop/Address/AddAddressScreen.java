package com.onestop.Address;

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
import com.onestop.R;

import java.util.ArrayList;
import java.util.List;

/*
EditTexts are not functional yet
*/

public class AddAddressScreen extends AppCompatActivity {

    Spinner spinnerAddressType;
    List<String> addressTypeList = new ArrayList<>();
    ImageButton ibBack;
    TextView tvTitle;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address_screen);

        spinnerAddressType = findViewById(R.id.address_type_spinner);
        btnSave = findViewById(R.id.save_address_btn);
        ibBack = findViewById(R.id.back_ib);
        tvTitle = findViewById(R.id.title_tv);

        tvTitle.setText(R.string.add_address);

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddAddressScreen.this, "Address Added", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AddAddressScreen.this, AddressScreen.class));
            }
        });

        addressTypeList.add("Home");
        addressTypeList.add("Work");
        addressTypeList.add("Other");

        ArrayAdapter<String> addressTypeAdapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_spinner_item, addressTypeList);
        addressTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAddressType.setAdapter(addressTypeAdapter);

        spinnerAddressType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(AddAddressScreen.this, "set as "+ parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
