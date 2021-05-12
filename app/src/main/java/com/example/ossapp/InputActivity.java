package com.example.ossapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class InputActivity extends AppCompatActivity {
      public static final String NUMBER = "message";
      private String textButton = "Запросить повторно через 00:%d";
      private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        button = (Button) findViewById(R.id.button);
        EditText editText = (EditText)findViewById(R.id.codeInput);
        Intent intent = getIntent();
        String number = intent.getStringExtra(NUMBER);
        TextView info = (TextView) findViewById(R.id.textViewInfo);
        info.setText("Код отправлен на номер "  + number);
        button.setEnabled(false);
        setTextButton();

        /*Это неправильно, надо думать как переделать*/
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_ENTER) {
                    /*логика отправки кода на сервер и принятия решение какую страницу
                    показывать пользователю дальше
                     */
                    return true;
                }
                return false;
            }
        });
    }
    public void repeatCode(View view) {
        //логика отправки запроса на сервер
          button.setEnabled(false);
          setTextButton();
    }
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
}