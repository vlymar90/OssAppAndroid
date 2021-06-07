package com.example.ossapp.registration;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import com.example.ossapp.R;
import com.example.ossapp.dto.UserDto;

public class InformationActivity extends AppCompatActivity {
    private EditText nameUser;
    private EditText ageUser;
    private EditText loginTelegram;
    private Button light;
    private Button medium;
    private Button heavy;
    private RadioButton male;
    private RadioButton female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        nameUser = (EditText) findViewById(R.id.nameUser);
        ageUser = (EditText) findViewById(R.id.ageUser);
        light = (Button) findViewById(R.id.light);
        medium = (Button) findViewById(R.id.medium);
        heavy = (Button) findViewById(R.id.heavy);
        male = (RadioButton) findViewById(R.id.muskul);
        female = (RadioButton) findViewById(R.id.female);
        loginTelegram = (EditText)findViewById(R.id.userNickTelegramm);
    }

    /*Это обработчик кнопки далее на страницы,
     * Основная функциональность сохранение данных о user
     * и открытие нового окна*/
    public void resumeInfo(View view) {
        try {
            int age = Integer.parseInt(ageUser.getText().toString());
            UserDto.setNameAgeTelegram(nameUser.getText().toString(), age,
                    loginTelegram.getText().toString());
            if (UserDto.getInstance().fullField()) {
                Intent nextActivityIntent = new Intent(this, CountryActivity.class);
                nextActivityIntent.putExtra("id", 1);
                startActivity(nextActivityIntent);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /*
    метод выбора весовой категории с изменением цвета кнопок
     */
    public void weightClick(int weight, Button nonSelectButton1, Button nonSelectButton2, Button selectButton) {
        UserDto.getInstance().setUserWeight(weight);
        selectButton.setBackgroundColor(Color.BLUE);
        selectButton.setTextColor(Color.WHITE);
        nonSelectButton1.setTextColor(Color.BLACK);
        nonSelectButton1.setBackgroundColor(Color.WHITE);
        nonSelectButton2.setTextColor(Color.BLACK);
        nonSelectButton2.setBackgroundColor(Color.WHITE);
    }
    //Метод выбора пола
    public void selectSex(View view) {
        RadioButton button = (RadioButton) view;
        if(button.getText().toString().equals("мужской")) {
            button.setChecked(true);
            female.setChecked(false);
            UserDto.getInstance().setSexUser(1);
        }
        else {
            male.setChecked(false);
            button.setChecked(true);
            UserDto.getInstance().setSexUser(2);
        }
    }
    //Метод обработчик выбора весовой категории
    public void selectWeight(View view) {
        Button weightButton = (Button) view;
        switch (weightButton.getText().toString()) {
            case "Лёгкий" :
                weightClick(1, medium, heavy, weightButton);
                break;
            case "Средний" :
                weightClick(2, light, heavy, weightButton);
                break;
            case "Тяжёлый" :
                weightClick(3, light, medium, weightButton);
                break;
        }
    }
}