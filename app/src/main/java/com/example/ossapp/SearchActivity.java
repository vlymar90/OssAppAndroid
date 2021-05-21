package com.example.ossapp;

import android.content.Intent;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ossapp.User.User;
import com.example.ossapp.util.FightersList;


public class SearchActivity extends AppCompatActivity {

    private RecyclerView partners;
    private FightersList fightersList;
    private ImageView filter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        partners = findViewById(R.id.partners);
        filter = findViewById(R.id.filter);

        /*
        создание списка бойцов
        нужно доработать чтобы принимать запросы из базы
         */
        LinearLayoutManager listOfPartners = new LinearLayoutManager(this);
        partners.setLayoutManager(listOfPartners);

        partners.setHasFixedSize(true);

        fightersList = new FightersList(30);
        partners.setAdapter(fightersList);

    }

    /*
    к фильтрам
     */
    public void filtered(View view) {
      //  Intent intent = new Intent(this, null);
      //  startActivity(intent);
    }

    /*
    к запросам
     */
    public void toQueries(View view) {
      //  Intent intent = new Intent(this, null);
       // startActivity(intent);
    }

    /*
    поиск партнера
     */
    public void search(View view) {
       // Intent intent = new Intent(this, null);
       // startActivity(intent);
    }

    /*
    переход к профилю
     */
    public void toProfile(View view) {
       // Intent intent = new Intent(this, null);
       // startActivity(intent);
    }

    /*
    выбор города
     */
    public void chooseCity(View view) {
      //  Intent intent = new Intent(this, null);
       // startActivity(intent);
    }
}
