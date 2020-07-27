package com.onestop.Order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.onestop.Home.Model.ProductModel;
import com.onestop.Order.Utils.OrderAdapter;
import com.onestop.R;
import com.onestop.SampleExample;

import java.util.ArrayList;
import java.util.List;

public class MyOrderScreen extends AppCompatActivity {

    TextView tvTitle;
    ImageButton ibBack;
    RecyclerView rvMyOrder;
    OrderAdapter adapter;
    SampleExample sampleExample = new SampleExample();
    List<ProductModel> orderList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order_screen);

        Toolbar toolbar = findViewById(R.id.toolbar);
        tvTitle = toolbar.findViewById(R.id.title_tv);
        rvMyOrder = findViewById(R.id.my_order_rv);
        ibBack = toolbar.findViewById(R.id.back_ib);

        tvTitle.setText(R.string.my_orders);

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        orderList.add(sampleExample.getProductList().get(0));
        orderList.add(sampleExample.getProductList().get(1));
        orderList.add(sampleExample.getProductList().get(2));

        adapter = new OrderAdapter(MyOrderScreen.this, orderList);

        rvMyOrder.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
