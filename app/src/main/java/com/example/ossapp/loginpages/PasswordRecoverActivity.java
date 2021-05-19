package com.example.ossapp.loginpages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ossapp.R;

public class PasswordRecoverActivity extends AppCompatActivity {
     private EditText userEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_recover);
        userEmail = (EditText)findViewById(R.id.userEmailRecoverPassword);
    }

    public void clearText(View view) {
        userEmail.setText("");
    }

    public void getPasswordByEmail(View view) {
        //Здесь логика отправки запроса на сервер а после вызываем
        //окно входа
        Intent input = new Intent(this, LoginPageActivity.class);
        startActivity(input);
    }
}