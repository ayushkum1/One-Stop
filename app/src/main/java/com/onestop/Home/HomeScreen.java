package com.onestop.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.onestop.R;

public class HomeScreen extends AppCompatActivity {

    ImageButton ibCake, ibShoe, ibStationery, ibCloth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        ibCake = findViewById(R.id.cake_ib);
        ibShoe = findViewById(R.id.shoe_ib);
        ibStationery = findViewById(R.id.stationery_ib);
        ibCloth = findViewById(R.id.cloth_ib);

        toast(ibCake, "cake");
        toast(ibShoe, "shoe");
        toast(ibCloth, "cloth");
        toast(ibStationery, "stationery");


    }

    public void toast(ImageButton btn, final String type){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(HomeScreen.this, MainActivity.class);
                mainIntent.putExtra("type", type);
                startActivity(mainIntent);
            }
        });
    }
}
