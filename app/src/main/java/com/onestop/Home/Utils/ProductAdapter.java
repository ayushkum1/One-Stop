package com.onestop.Home.Utils;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.onestop.Home.Model.ProductModel;
import com.onestop.ProductDetail.ProductDetailScreen;
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
        return new ProductViewHolder(LayoutInflater.from(context).inflate(R.layout.product_adapter_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, final int position) {

        holder.clProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(context, ProductDetailScreen.class);
                detailIntent.putExtra("product_name", productList.get(position).getProductName());
                detailIntent.putExtra("product_price", productList.get(position).getProductPrice());
                detailIntent.putExtra("product_weight", productList.get(position).getProductWeight());
                detailIntent.putExtra("product_description", productList.get(position).getProductDescription());
                context.startActivity(detailIntent);
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
        ConstraintLayout clProduct;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            tvProductName = itemView.findViewById(R.id.name_tv);
            tvProductPrice = itemView.findViewById(R.id.price_tv);
            tvProductDescription = itemView.findViewById(R.id.product_description_tv);

            ivProductPhoto = itemView.findViewById(R.id.product_image_iv);

            clProduct = itemView.findViewById(R.id.product_view_cl);
        }
    }
}
