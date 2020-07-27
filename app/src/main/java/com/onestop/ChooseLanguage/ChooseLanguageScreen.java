package com.onestop.ChooseLanguage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.onestop.ChooseLanguage.Utils.LanguageAdapter;
import com.onestop.R;

import java.util.ArrayList;
import java.util.List;

public class ChooseLanguageScreen extends AppCompatActivity {

    List<String> languageList = new ArrayList<>();
    LanguageAdapter adapter;
    RecyclerView rvLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_language_screen);

        getSupportActionBar().setTitle("Select Language");

        rvLanguage = findViewById(R.id.language_rv);

        languageList.add("English");
        languageList.add("Hindi");

        adapter = new LanguageAdapter(this, languageList);
        rvLanguage.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
