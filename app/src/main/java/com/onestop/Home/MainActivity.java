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

import com.google.android.material.navigation.NavigationView;
import com.onestop.Cart.CartScreen;
import com.onestop.Help.HelpScreen;
import com.onestop.Home.Model.ProductModel;
import com.onestop.Home.Utils.ProductAdapter;
import com.onestop.Order.MyOrderScreen;
import com.onestop.UserProfile.ProfileScreen;
import com.onestop.R;
import com.onestop.SampleExample;
import com.onestop.SearchResultScreen;
import com.onestop.Setting.SettingScreen;
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
    SampleExample sample = new SampleExample();

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
                        startActivity(new Intent(MainActivity.this, HelpScreen.class));
                        break;

                    case  R.id.settings:
                        startActivity(new Intent(MainActivity.this, SettingScreen.class));
                        break;

                    case R.id.orders:
                        startActivity(new Intent(MainActivity.this, MyOrderScreen.class));
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        //recycler view
        rvProduct = findViewById(R.id.product_rv);

        productList = sample.getProductList();

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