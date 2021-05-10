package com.example.ossapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InputActivity extends AppCompatActivity {
      public static final String NUMBER = "message";
      private Button button = (Button) findViewById(R.id.button);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        Intent intent = getIntent();
        String number = intent.getStringExtra(NUMBER);
        TextView info = (TextView) findViewById(R.id.textViewInfo);
        info.setText("Код отправлен на номер "  + number);
        button.setEnabled(false);
        new Thread(() -> {
            int time = 59;
            int x = 0;
            while (x < time) {
               button.setText(String.format("Запросить повторно через 00:%d", time));
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                time--;
               if(time == 1) {
                   button.setEnabled(true);
                   break;
               }
            }
        }
        ).run();
    }
    public void sendReg(View view) {
        EditText codeInput = (EditText)findViewById(R.id.codeInput);
        //логика отправки на сервер

    }
}