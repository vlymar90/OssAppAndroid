package com.example.ossapp.loginpages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import com.example.ossapp.R;

public class LoginPageActivity extends AppCompatActivity {
    private EditText userEmail;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpages);
        userEmail = (EditText)findViewById(R.id.userEmailLoginPage);
        password = (EditText)findViewById(R.id.userPassword);

    }
    //Открывает главную страницу приложения
    public void inputAccount(View view) {

    }
     //Чистит строку с email
    public void clearEmailText(View view) {
       userEmail.setText("");
    }
    //Показывает пароль
    public void openRecoverPassword(View view) {
        Intent recoverPassword = new Intent(this,PasswordRecoverActivity.class);
        startActivity(recoverPassword);
    }
    //Показывает пароль
    public void showPassword(View view) {
        password.setInputType(InputType.TYPE_CLASS_TEXT);
    }
}