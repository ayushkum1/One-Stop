package com.onestop.ChooseLanguage.Utils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.onestop.Login.LoginScreen;
import com.onestop.R;

import java.util.List;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.LanguageAdapterViewHolder> {

    Context context;
    List<String> languageList;

    public LanguageAdapter(Context context, List<String> languageList) {
        this.context = context;
        this.languageList = languageList;
    }

    @NonNull
    @Override
    public LanguageAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LanguageAdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.language_adapter_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LanguageAdapterViewHolder holder, int position) {
        holder.tvLanguageName.setText(languageList.get(position));
        holder.rbLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code here for language change
                //change name of intent
                Intent in = new Intent(context, LoginScreen.class);
                context.startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return languageList.size();
    }

    class LanguageAdapterViewHolder extends RecyclerView.ViewHolder {

        RadioButton rbLanguage;
        TextView tvLanguageName;

        LanguageAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            rbLanguage = itemView.findViewById(R.id.language_rb);
            tvLanguageName = itemView.findViewById(R.id.language_name_tv);
        }
    }
}
