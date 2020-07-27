package com.onestop.Order.Utils;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.onestop.Home.Model.ProductModel;
import com.onestop.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderAdapterViewHolder> {

    Context context;
    List<ProductModel> orderList;

    public OrderAdapter(Context context, List<ProductModel> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public OrderAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OrderAdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.order_adapter_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapterViewHolder holder, int position) {

        holder.tvOrderName.setText(orderList.get(position).getProductName());
        holder.tvOrderWeight.setText(orderList.get(position).getProductWeight());
        holder.tvOrderPrice.setText(orderList.get(position).getProductPrice());
        holder.tvOrderStatus.setText("Delivered");
        Picasso.with(context).load(orderList.get(position).getProductPhoto()).into(holder.ivOrderImage);
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    class OrderAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView tvOrderName, tvOrderWeight, tvOrderPrice, tvOrderStatus;
        ImageView ivOrderImage;

        public OrderAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            tvOrderName = itemView.findViewById(R.id.order_name_tv);
            tvOrderWeight = itemView.findViewById(R.id.order_weight_tv);
            tvOrderPrice = itemView.findViewById(R.id.order_price_tv);
            tvOrderStatus = itemView.findViewById(R.id.order_status_tv);
            ivOrderImage = itemView.findViewById(R.id.order_iv);
        }
    }
}
