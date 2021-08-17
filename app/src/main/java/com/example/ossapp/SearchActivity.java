package com.example.ossapp;

import android.content.Intent;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

    LinearLayout fighter;
    private RecyclerView partners;
    private FightersList fightersList;
    private TextView cityName;
    private String city;
    private List<UserResponseDto> listOfFighters;
    private String style;
    private String level;
    private int ageMin;
    private int ageMax;
    private String sex;
    private String weightId;

    //временные бойцы
    UserResponseDto userDto1;
    UserResponseDto userDto2;
    UserResponseDto userDto3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        partners = findViewById(R.id.partners);
        cityName = findViewById(R.id.city_name);
        fighter = findViewById(R.id.fighter);
        city = "Moscow on Don";
        cityName.setText(city);

        Intent filter = getIntent();
        // получение города
        if (filter.hasExtra("city")) {
            city = getIntent().getStringExtra("city");
            cityName.setText(city);
        }
        // получение информации от фильтров стиль, уровень, возраст макс. и мин. и т.д
        if (filter.hasExtra("style"))
            style = getIntent().getStringExtra("style");
        if (filter.hasExtra("level"))
            level = getIntent().getStringExtra("level");
        if (filter.hasExtra("ageMin")) {
            ageMin = (int) getIntent().getFloatExtra("ageMin", 20);
            ageMax = (int) getIntent().getFloatExtra("ageMax", 50);
        }

        // получаем пол и
        if (filter.hasExtra("sex")) {
            sex = getIntent().getStringExtra("sex");
        }

        // получаем вес
        if (filter.hasExtra("weight")) {
            weightId = getIntent().getStringExtra("weight");
        }


        // бойцы для проверки которых мы получим из базы
        userDto1 = new UserResponseDto();
        userDto1.setName("Ван Дам");
        userDto1.setUserAge(ageMin);
        userDto1.setCity(city);
        userDto1.setStyle(style);
        userDto1.setLevel(level);
        userDto1.setSexUser(sex);
        userDto1.setUserWeight(weightId);

        userDto2 = new UserResponseDto();
        userDto2.setName("Ли");
        userDto2.setUserAge(ageMin);
        userDto2.setCity(city);
        userDto2.setStyle(style);
        userDto2.setLevel(level);
        userDto2.setSexUser(sex);
        userDto2.setUserWeight(weightId);

        userDto3 = new UserResponseDto();
        userDto3.setName("Норрис");
        userDto3.setUserAge(ageMax);
        userDto3.setCity(city);
        userDto3.setStyle(style);
        userDto3.setLevel(level);
        userDto3.setSexUser(sex);
        userDto3.setUserWeight(weightId);

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

    // переход на карточку бойца
    public void lookAtFighter(View view) {
        int pos = partners.getChildAdapterPosition(view);
        for (int i = 0; i < listOfFighters.size(); i++) {
            if (i == pos){
                Intent intent = new Intent(this, PartnerActivity.class);
                intent.putExtra("dto", listOfFighters.get(i));
                startActivity(intent);
                return;
            }
        }
    }
}
