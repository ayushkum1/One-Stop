package com.onestop.Cart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.onestop.Cart.Utils.CartAdapter;
import com.onestop.Home.MainActivity;
import com.onestop.Home.Model.ProductModel;
import com.onestop.Home.Utils.ProductAdapter;
import com.onestop.Order.OrderScreen;
import com.onestop.R;

import java.util.ArrayList;
import java.util.List;

public class CartScreen extends AppCompatActivity {

    List<ProductModel> billingList = new ArrayList<>();
    RecyclerView rvCart;
    CartAdapter adapter;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_screen);

        getSupportActionBar().setTitle(getResources().getString(R.string.my_cart));
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_arrow);// set drawable icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvCart = findViewById(R.id.cart_rv);
        btnNext = findViewById(R.id.next_btn);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartScreen.this, OrderScreen.class));
            }
        });

       ProductModel pm4 = new ProductModel("Black Forest",
                "Rs. 500",
                "As its name implies, Black Forest Cake comes from the Black Forest region of Germany.\n",
                "https://img.floweraura.com/sites/default/files/Blackforest-cake-2Kg-eggless-A.jpg", "1kg");

        ProductModel pm5 = new ProductModel("Classic Cake",
                "Rs. 400",
                "As its name implies, Black Forest Cake comes from the Black Forest region of Germany.\n",
                "https://www.bbcgoodfood.com/sites/default/files/recipe-collections/collection-image/2013/05/carrot-cake.jpg", "1kg");

        ProductModel pm6 = new ProductModel("Pink Drip Cake",
                "Rs. 500",
                "As its name implies, Black Forest Cake comes from the Black Forest region of Germany.\n",
                "https://chelsweets.com/wp-content/uploads/2019/04/IMG_1029-2-735x1103.jpg", "1kg");

        billingList.add(pm4);
        billingList.add(pm5);
//        billingList.add(pm6);

        rvCart.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CartAdapter(CartScreen.this, billingList);
        rvCart.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
            }
        return  true;
    }
}
