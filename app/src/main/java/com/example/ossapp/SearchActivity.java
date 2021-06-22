package com.example.ossapp;

import android.content.Intent;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ossapp.dto.UserDto;
import com.example.ossapp.dto.UserResponseDto;
import com.example.ossapp.registration.CountryActivity;
import com.example.ossapp.util.FightersList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class SearchActivity extends AppCompatActivity {

    private RecyclerView partners;
    private FightersList fightersList;
    private ImageView filter;
    private TextView cityName;
    private String city;
    private List<UserResponseDto> listOfFighters;
    private String style;
    private String level;
    private int ageMin;
    private int ageMax;
    UserResponseDto userDto1;
    UserResponseDto userDto2;
    UserResponseDto userDto3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        partners = findViewById(R.id.partners);
        filter = findViewById(R.id.filter);
        cityName = findViewById(R.id.city_name);

        Intent filter = getIntent();
        // получение города
        if (filter.hasExtra("city")) {
            city = getIntent().getStringExtra("city");
            cityName.setText(city);
        }
        // получение информации от фильтров стиль, уровень, возраст макс. и мин.
        if (filter.hasExtra("style"))
            style = getIntent().getStringExtra("style");
        if (filter.hasExtra("level"))
            level = getIntent().getStringExtra("level");
        if (filter.hasExtra("ageMin")) {
            ageMin = (int) getIntent().getFloatExtra("ageMin", 20);
            ageMax = (int) getIntent().getFloatExtra("ageMax", 50);
        }



        // бойцы для проверки которых мы получим из базы
        userDto1 = new UserResponseDto();
        userDto1.setName("Ван Дам");
        userDto1.setUserAge(ageMin);
        userDto1.setUserWeight(80);
        userDto1.setCity(city);
        userDto1.setStyle(style);
        userDto1.setLevel(level);

        userDto2 = new UserResponseDto();
        userDto2.setName("Ли");
        userDto2.setUserAge(ageMax);
        userDto2.setUserWeight(65);
        userDto2.setCity(city);
        userDto2.setStyle(style);
        userDto2.setLevel(level);

        userDto3 = new UserResponseDto();
        userDto3.setName("Норрис");
        userDto3.setUserAge(ageMax);
        userDto3.setUserWeight(70);
        userDto3.setCity(city);
        userDto3.setStyle(style);
        userDto3.setLevel(level);

        listOfFighters = new LinkedList<>();
        /*
        вносим всех в список
        */
        listOfFighters.add(userDto1);
        listOfFighters.add(userDto2);
        listOfFighters.add(userDto3);
        listOfFighters.add(userDto1);
        listOfFighters.add(userDto2);
        listOfFighters.add(userDto3);


        /*
        создание Recycler View
        */
        LinearLayoutManager listOfPartners = new LinearLayoutManager(this);
        partners.setLayoutManager(listOfPartners);
        partners.setHasFixedSize(true);

        /*
        сюда помещаем список бойцов
         */
        fightersList = new FightersList(listOfFighters);
        partners.setAdapter(fightersList);
    }

    /*
    к фильтрам
     */
    public void filtered(View view) {
        // город тоже идет в фильтры, чтобы вернуть потом
        Intent intent = new Intent(this, FiltersActivity.class);
        intent.putExtra("city", city);
        startActivity(intent);
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
        Intent intent = new Intent(this, CountryActivity.class);
        intent.putExtra("id", 2);
        startActivity(intent);
    }
}
