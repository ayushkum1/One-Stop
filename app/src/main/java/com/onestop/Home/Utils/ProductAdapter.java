package com.onestop.Home.Utils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.onestop.Home.Model.ProductModel;
import com.onestop.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context context;
    List<ProductModel> productList;

    public ProductAdapter(Context context, List<ProductModel> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(context).inflate(R.layout.product_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.llProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
            }
        });
        holder.tvProductName.setText(productList.get(position).getProductName());
        holder.tvProductPrice.setText(productList.get(position).getProductPrice());
        holder.tvProductDescription.setText(productList.get(position).getProductDescription());
        Picasso.with(context).load(productList.get(position).getProductPhoto()).into(holder.ivProductPhoto);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{

        TextView tvProductName, tvProductPrice, tvProductDescription;
        ImageView ivProductPhoto;
        LinearLayout llProduct;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            tvProductName = itemView.findViewById(R.id.name_tv);
            tvProductPrice = itemView.findViewById(R.id.price_tv);
            tvProductDescription = itemView.findViewById(R.id.description_tv);

            ivProductPhoto = itemView.findViewById(R.id.product_image_iv);

            llProduct = itemView.findViewById(R.id.product_view_ll);
        }
    }
}
