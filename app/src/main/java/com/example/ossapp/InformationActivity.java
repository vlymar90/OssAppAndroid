package com.example.ossapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InformationActivity extends AppCompatActivity {
    private EditText nameUser;
    private EditText ageUser;
    private EditText weightUser;
    private EditText descriptionUser;
    private EditText sexUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        nameUser = (EditText)findViewById(R.id.nameUser);
        ageUser = (EditText)findViewById(R.id.ageUser);
        weightUser = (EditText)findViewById(R.id.weightUser);
        descriptionUser = (EditText)findViewById(R.id.descriptionUser);
    }
    /*Это обработчик кнопки далее на страницы,
     * Основная функциональность сохранение данных о user
     * и открытие нового окна*/
    public void resumeInfo(View view) {
        Context context = InformationActivity.this;
        Intent nextActivityIntent = new Intent(context, AvatarActivity.class);
        startActivity(nextActivityIntent);
    }

//    public void setSexMen(View view) {
//
//    }
//
//    public void setSexWoman(View view) {
//    }
}