package com.example.ossapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AuthenticationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
    }

    public void sendAuth(View view) {
        EditText code = (EditText)findViewById(R.id.code);
        EditText numberPhone = (EditText)findViewById(R.id.number);
        //Здесь логика отпраки номере телефона на сервер....
        Intent intent = new Intent(this, InputActivity.class);
        intent.putExtra(InputActivity.NUMBER, code.getText().toString() + numberPhone.getText().toString());
        startActivity(intent);

    }
}