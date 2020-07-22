package com.onestop.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.onestop.Cart.CartScreen;
import com.onestop.Home.Model.ProductModel;
import com.onestop.Home.Utils.ProductAdapter;
import com.onestop.Profile.ProfileScreen;
import com.onestop.R;
import com.onestop.SearchResultScreen;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/*
1.add profile photo in header
*/

public class MainActivity extends AppCompatActivity {
    //navigation drawer
    DrawerLayout drawer;

    //recycler view
    RecyclerView rvProduct;
    List<ProductModel> productList = new ArrayList<>();
    ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting the menu icon in top action bar
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.navigation_menu);// set drawable icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //navigation drawer
        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);

        //actionBarDrawerToggle.setHomeAsUpIndicator(R.drawable.menu_hamburger);
        //for header, takes to update profile
        View headerView = navigationView.getHeaderView(0);
        TextView tvDoMore = headerView.findViewById(R.id.do_more);
        ImageView ivProfilePicture = headerView.findViewById(R.id.profile_picture_iv);

        Picasso.with(this).load("https://i.postimg.cc/gc8zy1QF/Ayush-Photo0002.jpg").into(ivProfilePicture);

        tvDoMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileScreen.class));
            }
        });

        //for navigation items, takes to respective selected activity
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.cart:
                        startActivity(new Intent(MainActivity.this, CartScreen.class));
                        break;

                    case R.id.help:
                        startActivity(new Intent(MainActivity.this, HomeScreen.class));
                        Toast.makeText(MainActivity.this, "help", Toast.LENGTH_SHORT).show();
                        break;

                    case  R.id.settings:
                        Toast.makeText(MainActivity.this, "setting", Toast.LENGTH_SHORT).show();
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        //recycler view
        rvProduct = findViewById(R.id.product_rv);

        ProductModel pm1 = new ProductModel("Black Forest",
                "Rs. 500",
                "As its name implies, Black Forest Cake comes from the Black Forest region of Germany.\n",
                "https://www.lifeloveandsugar.com/wp-content/uploads/2015/02/Chocolate-Oreo-Cake2.jpg", "1 kg");

        ProductModel pm2 = new ProductModel("Black Forest",
                "Rs. 500",
                "As its name implies, Black Forest Cake comes from the Black Forest region of Germany.\n",
                "https://img.floweraura.com/sites/default/files/Blackforest-cake-2Kg-eggless-A.jpg", "1kg");

        ProductModel pm3 = new ProductModel("Black Forest",
                "Rs. 500",
                "As its name implies, Black Forest Cake comes from the Black Forest region of Germany.\n",
                "https://www.lifeloveandsugar.com/wp-content/uploads/2015/02/Chocolate-Oreo-Cake2.jpg", "1 kg");

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

        ProductModel pm7 = new ProductModel("Party Cake",
                "Rs. 700",
                "As its name implies, Black Forest Cake comes from the Black Forest region of Germany.\n",
                "https://www.pamperedchef.com/iceberg/com/recipe/1125065-lg.jpg", "1kg");

        ProductModel pm8 = new ProductModel("Strawberry Cake",
                "Rs. 500",
                "As its name implies, Black Forest Cake comes from the Black Forest region of Germany.\n",
                "https://sugargeekshow.com/wp-content/uploads/2019/07/fresh-strawberry-cake-5.jpg", "1kg");

        productList.add(pm1);
        productList.add(pm2);
        productList.add(pm3);
        productList.add(pm4);
        productList.add(pm5);
        productList.add(pm6);
        productList.add(pm7);
        productList.add(pm8);

        rvProduct.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProductAdapter(MainActivity.this, productList);
        rvProduct.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                if(drawer.isDrawerOpen(GravityCompat.START)){
                    drawer.closeDrawer(GravityCompat.START);
                }
                else {
                    drawer.openDrawer(GravityCompat.START);
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        //search view
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        android.widget.SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        assert searchManager != null;
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                startActivity(new Intent(MainActivity.this, SearchResultScreen.class));
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }
}
