package com.example.ossapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ossapp.util.UtilButton;

public class InputActivity extends AppCompatActivity {
      public static final String NUMBER = "message";
      private String nameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        Button button = (Button) findViewById(R.id.button);
        EditText editText = (EditText)findViewById(R.id.codeInput);
        Intent intent = getIntent();
        String number = intent.getStringExtra(NUMBER);
        TextView info = (TextView) findViewById(R.id.textViewInfo);
        info.setText("Код отправлен на номер "  + number);
//        UtilButton.setButtonText(button);
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
//        UtilButton.setButtonText(button);
    }
}