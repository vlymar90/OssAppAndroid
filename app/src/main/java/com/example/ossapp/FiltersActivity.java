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
import java.util.List;

public class FiltersActivity extends AppCompatActivity {

    private TextView cancel;
    private ImageView back;

    private RangeSlider ageSlider;

    private ArrayList<Button> buttons;

    private String city;
    private String weightId;
    private String sexId;
    private float ageMin;
    private float ageMax;
    private String level;
    private String style;
    private List<Button> styles;
    private List<Button> levels;
    private List<Button> sex;
    private List<Button> weights;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);

        // приходит город из списка бойцов
        city = getIntent().getStringExtra("city");

        buttons = new ArrayList<>(); //хранит все кнопки, для очистки фильтров
        styles = new ArrayList<>(); //хранит кнопки стилей, чтобы они потом деактивировались
        levels = new ArrayList<>(); //хранит кнопки уровней, чтобы они потом деактивировались

        ageSlider = findViewById(R.id.slider);
        ageSlider.setValues(20f, 50f); // выбор возраста


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
        ageMin = ageSlider.getValues().get(0);
        ageMax = ageSlider.getValues().get(ageSlider.getValues().size() - 1);
        intent.putExtra("style", style);
        intent.putExtra("level", level);
        intent.putExtra("city", city);
        intent.putExtra("ageMin", ageMin);
        intent.putExtra("ageMax", ageMax);
        intent.putExtra("sex", sexId);
        intent.putExtra("weight", weightId);
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
            buttons.remove(selectButton);
        }
    }

    //нажатие на кнопку любого стиля
    public void buttonStyleClick(View view) {
        Button button = (Button) view;
        buttonChooseClick(view, styles);
        style = button.getText().toString();
    }

    //нажатие на кнопку выбора уровня
    public void buttonLevelClick(View view) {
        Button button = (Button) view;
        buttonChooseClick(view, levels);
        level = button.getText().toString();
    }

    public void buttonsSexClick(View view){
        Button button = (Button) view;
        buttonChooseClick(view, sex);
        sexId = button.getText().toString();
    }

    public void buttonWeightClick(View view){
        Button button = (Button) view;
        buttonChooseClick(view, weights);
        weightId = button.getText().toString();
    }

    // общий метод выбора только одного элемента
    public void buttonChooseClick(View view, List<Button> views) {
        Button button = (Button) view;
        for (Button bt : views) {
            if (bt.isSelected()) {
                bt.setBackgroundColor(Color.WHITE);
                bt.setTextColor(Color.BLACK);
                bt.setSelected(false);
                buttons.remove(bt);
            }
        }
        views.add(button);
        buttonClick(view);
    }
}
