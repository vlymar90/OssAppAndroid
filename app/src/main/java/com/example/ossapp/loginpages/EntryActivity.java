package com.example.ossapp.loginpages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ossapp.registration.AuthenticationActivity;
import com.example.ossapp.R;

public class EntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
    }
    /*
    * открывает страницу с правилами пользования*/
    public void openRulesActivity(View view) {
        Intent rules = new Intent(this, RulesActivity.class);
        startActivity(rules);
    }

    public void openProfile(View view) {
       Intent loginPage = new Intent(this, LoginPageActivity.class);
       startActivity(loginPage);
    }
   //Открывает страницу регистрации
    public void createAccount(View view) {
        Intent auth = new Intent(this, AuthenticationActivity.class);
        startActivity(auth);
    }
}