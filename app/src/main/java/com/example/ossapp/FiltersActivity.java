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
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class FiltersActivity extends AppCompatActivity {

    private TextView cancel;
    private ImageView back;
    private Button mma;
    private Button bzhzh;
    private Button kickboxing;
    private Button karate;
    private Button sambo;
    private Button taekwondo;
    private Button judo;
    private Button wrestling;
    private Button grappling;
    private Button rookie;
    private Button medium;
    private Button advanced;
    private Button professional;
    private Button male;
    private Button female;
    private Button light;
    private Button halfHeavy;
    private Button heavy;
    private RangeSlider ageSlider;
    private ArrayList<Button> buttons;

    private int weight;
    private int sex;
    private int age;
    private long style;
    private long level;
    private long[] styles = new long[3];
    private List list = new LinkedList<Long>();
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);

        buttons = new ArrayList<>();

        ageSlider = findViewById(R.id.slider);
        ageSlider.setValues(18f, 38f);

        mma = findViewById(R.id.button1);
        bzhzh = findViewById(R.id.button2);
        kickboxing = findViewById(R.id.button3);
        karate = findViewById(R.id.button4);
        sambo = findViewById(R.id.button5);
        taekwondo = findViewById(R.id.button6);
        judo = findViewById(R.id.button7);
        wrestling = findViewById(R.id.button8);
        grappling = findViewById(R.id.button9);
        rookie = findViewById(R.id.button10);
        medium = findViewById(R.id.button11);
        advanced = findViewById(R.id.button12);
        professional = findViewById(R.id.button13);
        male = findViewById(R.id.button14);
        female = findViewById(R.id.button15);
        light = findViewById(R.id.button16);
        halfHeavy = findViewById(R.id.button17);
        heavy = findViewById(R.id.button18);
    }

    public void buttonStyleClick(View view) {
        Button button = (Button) view;
        if (count <= 3) {
            if (mma.equals(view)) {
                style = 1;
                buttonClick(view);
                choosingStyle(button, style);
            } else if (bzhzh.equals(view)) {
                style = 2;
                buttonClick(view);
                choosingStyle(button, style);
            } else if (kickboxing.equals(view)) {
                style = 3;
                buttonClick(view);
                choosingStyle(button, style);
            } else if (karate.equals(view)) {
                style = 4;
                buttonClick(view);
                choosingStyle(button, style);
            }
        } else {
            return;
        }
    }

    /*
    сброс всех фильтров
     */
    public void cancelFilter(View view) {
        for (Button button : buttons) {
            button.setBackgroundColor(Color.WHITE);
            button.setTextColor(Color.BLACK);
            button.setPressed(false);
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
        Intent intent = new Intent(this, SearchActivity.class);
        intent.putExtra("style", list.toArray());
        startActivity(intent);
    }

    /*
    нажатие на кнопку
     */
    public void buttonClick(View view) {
        Button selectButton = (Button) view;
        if (!selectButton.isSelected()) {
            selectButton.setBackgroundColor(Color.BLUE);
            selectButton.setTextColor(Color.WHITE);
            selectButton.setSelected(true);
            buttons.add(selectButton);
        } else if (selectButton.isSelected()) {
            selectButton.setBackgroundColor(Color.WHITE);
            selectButton.setTextColor(Color.BLACK);
            selectButton.setSelected(false);
        }
    }

    public void choosingStyle(Button button, Long style) {
        if (button.isPressed()) {
            list.add(style);
            count++;
        } else if (!button.isPressed()) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == style) {
                    list.remove(list.get(i));
                    count--;
                }
            }
        }
    }
}