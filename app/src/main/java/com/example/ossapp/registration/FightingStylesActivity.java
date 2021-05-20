package com.example.ossapp.registration;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ossapp.R;
import com.example.ossapp.User.User;

public class FightingStylesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fighting_styles);
    }
    /*Метод - слушатель для всех кнопок. Меняет состояние кнопки*/
    public void selectStyle(View view) {
        Button button = (Button) view;
        String nameButton = button.getText().toString();
        if (!User.getInstance().getUserStyleList().containsKey(nameButton) ) {
            if (User.getInstance().getUserStyleList().size() < 3)  {
                User.getInstance().getUserStyleList().put(nameButton, null);
                button.setTextColor(Color.WHITE);
                button.setBackgroundColor(Color.BLUE);
            }
        }
        else {
            User.getInstance().getUserStyleList().remove(nameButton);
            button.setTextColor(Color.BLACK);
            button.setBackgroundColor(Color.WHITE);
        }
    }


    public void nextStage(View view) {
        if (User.getInstance().getUserStyleList().size() != 0) {
            Intent intent = new Intent(this, null);
            startActivity(intent);
        }
    }
}