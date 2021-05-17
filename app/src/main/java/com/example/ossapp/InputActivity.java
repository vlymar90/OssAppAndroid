package com.example.ossapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InputActivity extends AppCompatActivity {
    public static final String NUMBER = "message";
    private String textButton = "Запросить повторно через 00:%d";
    private Button button;
    private EditText codeInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        button = (Button) findViewById(R.id.button);
        codeInput = (EditText)findViewById(R.id.codeInput);
        Intent intent = getIntent();
        String number = intent.getStringExtra(NUMBER);
        TextView info = (TextView) findViewById(R.id.textViewInfo);
        info.setText("Введите код, отправленные на "  + number);
        button.setEnabled(false);
        setTextButton();
    }
    /*Метод повторного запроса кода*/
    public void repeatCode(View view) {
        //логика отправки запроса на сервер
        button.setEnabled(false);
        setTextButton();
    }

    /*Метод устанавливает на кнопку "таймер".
     * Пока идёт время кнопка не активна */
    private void setTextButton() {
        new CountDownTimer(59000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                button.setText(String.format(textButton, millisUntilFinished/1000));
            }
            @Override
            public void onFinish() {
                button.setText("повторить");
                button.setEnabled(true);
            }
        }.start();
    }
    /*Метод для подтверждения, введеного пользователем кода.
     * Пока не реализован. Написаный код просто для тестовой навигации
     * по приложению */
    public void sendReg(View view) {
        Intent intent = new Intent(this, FightingStylesActivity.class);
        startActivity(intent);
    }
}