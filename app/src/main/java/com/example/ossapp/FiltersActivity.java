package com.example.ossapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.slider.RangeSlider;

import java.util.ArrayList;

public class FiltersActivity extends AppCompatActivity {

    private TextView cancel;
    private ImageView back;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;
    private Button button13;
    private Button button14;
    private Button button15;
    private Button button16;
    private Button button17;
    private Button button18;
    private RangeSlider ageSlider;
    private ArrayList<Button> buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);

        buttons = new ArrayList<>();

        ageSlider = findViewById(R.id.slider);
        ageSlider.setValues(18f, 38f);



       /* button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button13 = findViewById(R.id.button13);
        button14 = findViewById(R.id.button14);
        button15 = findViewById(R.id.button15);
        button16 = findViewById(R.id.button16);
        button17 = findViewById(R.id.button17);
        button18 = findViewById(R.id.button18);*/
    }

    /*
    сброс всех фильтров
     */
    public void cancelFilter(View view) {
        for (Button button : buttons) {
            ;
            button.setBackgroundColor(Color.WHITE);
            button.setTextColor(Color.BLACK);
        }
        buttons.clear();
        ageSlider.setValues(20f, 50f);
    }

    /*
    назад без применения фильтров
     */
    public void backWithoutFilters(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    /*
    назад с фильтрами
     */
    public void nextActivity(View view) {

    }

    /*
    нажатие на кнопку
     */
    public void buttonClick(View view) {
        Button selectButton = (Button) view;
        selectButton.setBackgroundColor(Color.BLUE);
        selectButton.setTextColor(Color.WHITE);
        buttons.add(selectButton);
    }
}