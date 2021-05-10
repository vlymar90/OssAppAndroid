package com.example.ossapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AuthenticationActivity extends AppCompatActivity {
//    EditText editText = (EditText)findViewById(R.id.)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
    }

    public void sendAuth(View view) {
        EditText code = (EditText)findViewById(R.id.code);
        EditText numberPhone = (EditText)findViewById(R.id.number);
        StringBuilder total = new StringBuilder(code.getText().append(numberPhone.getText()));
        //Здесь логика отпраки номере телефона на сервер....
        Intent intent = new Intent(this, InputActivity.class);
        intent.putExtra(InputActivity.NUMBER, total.toString());
        startActivity(intent);

    }
}