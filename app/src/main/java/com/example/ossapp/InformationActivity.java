package com.example.ossapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.ossapp.User.User;

public class InformationActivity extends AppCompatActivity {
    private EditText nameUser;
    private EditText ageUser;
    private Button light;
    private Button medium;
    private Button heavy;
    private RadioButton male;
    private RadioButton female;
    User user = new User();
    /*
    вес и пол надо будет тащить вместе с объектом User
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        nameUser = (EditText) findViewById(R.id.nameUser);
        ageUser = (EditText) findViewById(R.id.ageUser);
        light = (Button) findViewById(R.id.light);
        medium = (Button) findViewById(R.id.medium);
        heavy = (Button) findViewById(R.id.heavy);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);



    /*
    три метода выбора весовой категории
     */
        light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightClick(light, medium, heavy);
                user.setUserWeight(1);
            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightClick(medium, light, heavy);
                user.setUserWeight(2);
            }
        });


        heavy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightClick(heavy, medium, light);
                user.setUserWeight(3);
            }
        });


    /*
    два метода выбора пола
     */
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setChecked(true);
                female.setChecked(false);
                user.setSexUser(1);
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setChecked(false);
                female.setChecked(true);
                user.setSexUser(2);
            }
        });


        //descriptionUser = (EditText)findViewById(R.id.descriptionUser);
    }

    /*Это обработчик кнопки далее на страницы,
     * Основная функциональность сохранение данных о user
     * и открытие нового окна*/
    public void resumeInfo(View view) {
        Context context = InformationActivity.this;
        //user.setUserName(nameUser.getText().toString());
        //user.setUserAge (Integer.parseInt(ageUser.getText().toString()));
        Intent nextActivityIntent = new Intent(context, FightingStylesActivity.class);
        startActivity(nextActivityIntent);
    }

    /*
    метод выбора весовой категории с изменением цвета кнопок
     */
    public void weightClick(Button light, Button medium, Button heavy) {
        light.setBackgroundColor(Color.BLUE);
        light.setTextColor(Color.WHITE);
        medium.setBackgroundColor(Color.WHITE);
        medium.setTextColor(Color.BLACK);
        heavy.setBackgroundColor(Color.WHITE);
        heavy.setTextColor(Color.BLACK);
    }
}