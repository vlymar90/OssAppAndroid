package com.example.ossapp.registration;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ossapp.R;
import com.example.ossapp.SearchActivity;
import com.example.ossapp.User.User;
import com.example.ossapp.util.StyleListSelect;

public class FightingStylesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fighting_styles);
    }

    /*Метод - слушатель для всех кнопок. Меняет состояние кнопки*/
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void selectStyle(View view) {
        Button button = (Button) view;
        String nameButton = button.getText().toString();
        if (!StyleListSelect.listStyle.contains(nameButton)) {
            if (StyleListSelect.listStyle.size() < 3) {
                StyleListSelect.listStyle.add(nameButton);
                button.setTextColor(Color.WHITE);
                button.setBackgroundColor(Color.BLUE);
            }
        } else {
            StyleListSelect.listStyle.removeIf(i -> i.equals(nameButton));
            button.setTextColor(Color.BLACK);
            button.setBackgroundColor(Color.WHITE);
        }
    }

    public void nextStage(View view) {
        if (User.getInstance().getUserStyleList().size() != 0) {
            Intent intent = new Intent(this, SearchActivity.class);
        }
        if (StyleListSelect.listStyle.size() != 0) {
            Intent intent = new Intent(this, MasterLevelActivity.class);
            startActivity(intent);
        }
    }
}