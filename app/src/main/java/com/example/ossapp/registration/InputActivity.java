package com.example.ossapp.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ossapp.R;
import com.example.ossapp.RulesActivity;
import com.example.ossapp.dto.UserDto;

public class InputActivity extends AppCompatActivity {
    public static final String EMAIL = "message";
    private EditText codeInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        codeInput = (EditText)findViewById(R.id.codeInput);
        Intent intent = getIntent();
        String number = intent.getStringExtra(EMAIL);
        TextView info = (TextView) findViewById(R.id.textViewInfo);
        info.setText("Мы отправили 6-тизначный код на " + EMAIL +
                ". "+ "Введите полученный код.");
    }
    /*Метод повторного запроса кода*/
    public void repeatCode(View view) {
        //логика отправки запроса на сервер

    }

    public void sendReg(View view) {
        Intent intent = new Intent(this, PasswordActivity.class);
        startActivity(intent);
    }
}