package com.onestop.Cart.Utils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.onestop.Home.Model.ProductModel;
import com.onestop.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    Context context;
    List<ProductModel> billingList;
    private int count = 1;

    public CartAdapter(Context context, List<ProductModel> productList) {
        this.context = context;
        this.billingList = productList;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CartViewHolder(LayoutInflater.from(context).inflate(R.layout.cart_adapter_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

        holder.btnPlusCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count += 1;
            }
        });

        holder.btnMinusCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count -= 1;
            }
        });

        holder.tvCount.setText(String.valueOf(count));

        holder.tvProductName.setText(billingList.get(position).getProductName());
        holder.tvProductPrice.setText(billingList.get(position).getProductPrice());
        holder.tvProductWeight.setText(billingList.get(position).getProductWeight());
        Picasso.with(context).load(billingList.get(position).getProductPhoto()).into(holder.ivProductPhoto);
    }

    @Override
    public int getItemCount() {
        return billingList.size();
    }

    class CartViewHolder extends RecyclerView.ViewHolder {

        TextView tvProductName, tvProductPrice, tvProductWeight, tvCount;
        ImageView ivProductPhoto;
        Button btnPlusCount, btnMinusCount;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductName = itemView.findViewById(R.id.name_tv);
            tvProductPrice = itemView.findViewById(R.id.price_tv);
            tvProductWeight = itemView.findViewById(R.id.product_weight_tv);
            tvCount = itemView.findViewById(R.id.count_tv);

            ivProductPhoto = itemView.findViewById(R.id.product_image_iv);

            btnPlusCount = itemView.findViewById(R.id.plus_btn);
            btnMinusCount = itemView.findViewById(R.id.minus_btn);

        }
    }
}
