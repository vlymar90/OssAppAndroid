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
    private List<Long> styles;
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
        // получение информации от фильтров
        if (filter.hasExtra("style")) {
            for (Long st : getIntent().getLongArrayExtra("style")) {
                styles.add(st);
            }
            userDto1.setStyleLevelList(styles);
            userDto2.setStyleLevelList(styles);
            userDto3.setStyleLevelList(styles);
        }


        // бойцы для проверки которых мы получим из базы
        userDto1 = new UserResponseDto();
        userDto1.setName("Ван Дам");
        userDto1.setUserAge(35);
        userDto1.setUserWeight(80);
        userDto1.setCity(city);

        userDto2 = new UserResponseDto();
        userDto2.setName("Ли");
        userDto2.setUserAge(29);
        userDto2.setUserWeight(65);
        userDto2.setCity(city);

        userDto3 = new UserResponseDto();
        userDto3.setName("Норрис");
        userDto3.setUserAge(34);
        userDto3.setUserWeight(70);
        userDto3.setCity(city);

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
        Intent intent = new Intent(this, FiltersActivity.class);
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
