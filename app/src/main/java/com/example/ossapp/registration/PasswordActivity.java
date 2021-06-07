package com.example.ossapp.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import com.example.ossapp.R;
import com.example.ossapp.dto.UserDto;

public class PasswordActivity extends AppCompatActivity {
    private EditText userPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        userPassword = (EditText) findViewById(R.id.userPasswordActivityPassword);
    }

    public void showPassword(View view) {
         userPassword.setInputType(InputType.TYPE_CLASS_TEXT);
    }

    public void nextActivity(View view) {
        if(userPassword.length() > 7) {
            UserDto.getInstance().setPassword(userPassword.toString());
            Intent infoIntent = new Intent(this, InformationActivity.class);
            startActivity(infoIntent);
        }
    }
}