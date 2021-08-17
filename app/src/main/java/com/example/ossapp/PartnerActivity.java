package com.example.ossapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ossapp.dto.UserResponseDto;

// карточка бойца
public class PartnerActivity extends AppCompatActivity {
    private UserResponseDto user;
    private TextView name;
    private TextView city;
    private TextView age;
    private TextView styleLevel;
    private TextView sex;
    private TextView weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner);

        name = findViewById(R.id.partners_name);
        city = findViewById(R.id.partners_city);
        age = findViewById(R.id.partners_age);
        styleLevel = findViewById(R.id.partners_style_level);
        weight = findViewById(R.id.partners_weight);

        //карточка бойца в разработке
        Intent intent = getIntent();
        if (intent.hasExtra("dto")) {
            user = (UserResponseDto) intent.getSerializableExtra("dto");

            name.setText(user.getName());
            city.setText(user.getCity());
            age.setText(String.valueOf(user.getUserAge()));
            styleLevel.setText(user.getStyle() + " " + user.getLevel());
            weight.setText(user.getUserWeight());
        }
    }

    // возврат на список партнёров
    public void backToList(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }
}
