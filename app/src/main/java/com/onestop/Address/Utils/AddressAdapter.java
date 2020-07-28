package com.onestop.Address.Utils;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.onestop.Address.Model.AddressModel;
import com.onestop.ChooseLanguage.Utils.LanguageAdapter;
import com.onestop.R;
import com.onestop.UserProfile.Model.UserModel;

import java.util.List;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.AddressAdapterViewHolder> {

    Context context;
    List<AddressModel> addressList;

    public AddressAdapter(Context context, List<AddressModel> addressList) {
        this.context = context;
        this.addressList = addressList;
    }

    @NonNull
    @Override
    public AddressAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AddressAdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.address_adapter_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final AddressAdapterViewHolder holder, int position) {

        String address, houseno, buildingname, streetname, pincode, city, state;



        houseno = addressList.get(position).getAddressHouseNo();
        buildingname = addressList.get(position).getAddressBuildingName();
        streetname = addressList.get(position).getAddressStreetName();
        pincode = addressList.get(position).getAddressPinCode();
        city = addressList.get(position).getAddressCity();
        state = addressList.get(position).getAddressState();

        address = houseno + " " + buildingname + "\n" + streetname  + " " + city  + " " + pincode  + "\n" + state;

        holder.tvName.setText(addressList.get(position).getAddressOwnerName());
        holder.tvAddressType.setText(addressList.get(position).getAddressType());
        holder.tvAddress.setText(address);
        holder.tvPhone.setText(addressList.get(position).getAddressPhone());

        holder.ibMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context, holder.ibMore);
                popupMenu.inflate(R.menu.address_menu);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.edit:
                                Toast.makeText(context, "edit", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.delete:
                                Toast.makeText(context, "delete", Toast.LENGTH_SHORT).show();
                                break;

                            default:
                                Toast.makeText(context, "default", Toast.LENGTH_SHORT).show();
                                break;
                        }

                        return false;
                    }
                });

                popupMenu.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return addressList.size();
    }

    class AddressAdapterViewHolder extends RecyclerView.ViewHolder{

        TextView tvName, tvAddressType, tvAddress, tvPhone;
        ImageButton ibMore;

        AddressAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.name_tv);
            tvAddressType = itemView.findViewById(R.id.address_type_tv);
            tvAddress = itemView.findViewById(R.id.address_tv);
            tvPhone = itemView.findViewById(R.id.phone_no_tv);
            ibMore = itemView.findViewById(R.id.more_ib);
        }
    }
}
