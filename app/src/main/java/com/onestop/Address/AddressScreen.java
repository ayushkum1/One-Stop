package com.onestop.Address;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.onestop.Address.Model.AddressModel;
import com.onestop.Address.Sample.AddressSampleData;
import com.onestop.Address.Utils.AddressAdapter;
import com.onestop.R;
import com.onestop.UserProfile.Model.UserModel;
import com.onestop.UserProfile.Sample.UserSampleData;

import java.util.ArrayList;
import java.util.List;

public class AddressScreen extends AppCompatActivity {

    List<UserModel> userList = new ArrayList<>();
    List<AddressModel> addressList = new ArrayList<>();
    AddressAdapter adapter;
    RecyclerView rvAddress;
    ImageButton ibBack;
    TextView tvTitle, tvAddAddress;
    AddressSampleData addressSampleData = new AddressSampleData();
    UserSampleData userSampleData = new UserSampleData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_screen);

        rvAddress = findViewById(R.id.address_rv);
        ibBack = findViewById(R.id.back_ib);
        tvTitle = findViewById(R.id.title_tv);
        tvAddAddress = findViewById(R.id.add_address_tv);

        tvTitle.setText(R.string.address);

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tvAddAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddressScreen.this, AddAddressScreen.class));
            }
        });

        userList = userSampleData.getUserList();
        addressList = addressSampleData.getAddressList();

        adapter = new AddressAdapter(this, addressList);

        rvAddress.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
