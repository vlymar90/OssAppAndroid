package com.example.ossapp;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.ossapp.User.User;
import com.example.ossapp.util.UtilSelectStyle;

public class FightingStylesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fighting_styles);
    }
    /*Метод - слушатель для всех кнопок. Меняет состояние кнопки*/
    public void selectStyle(View view) {
        Button button = (Button) view;
        if (User.getInstance().getUserStyleList().size() != 3) {
            if (UtilSelectStyle.selectStyle(button.getText().toString())) {
                button.setTextColor(Color.WHITE);
                button.setBackgroundColor(Color.DKGRAY);
            } else {
                button.setTextColor(Color.BLACK);
                button.setBackgroundColor(Color.LTGRAY);
            }
        }
    }


    public void nextStage(View view) {
        if (User.getInstance().getUserStyleList().size() != 0) {
            Intent intent = new Intent(this, null);
            startActivity(intent);
        }
    }
}