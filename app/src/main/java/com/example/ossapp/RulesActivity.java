package com.example.ossapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RulesActivity extends AppCompatActivity {

    private Button accept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        accept = (Button) findViewById(R.id.button5);
    }

    /*
    метод принятия и продолжения
     */
    public void accept(View view) {
        Intent intent = new Intent(this, InformationActivity.class);
        startActivity(intent);
    }
}