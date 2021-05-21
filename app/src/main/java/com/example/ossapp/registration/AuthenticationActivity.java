package com.example.ossapp.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ossapp.R;

public class AuthenticationActivity extends AppCompatActivity {
    private EditText emailUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        emailUser = (EditText)findViewById(R.id.emailUser);
    }

    public void sendAuth(View view) {
        //Здесь логика отпраки номере телефона на сервер....
        Intent intent = new Intent(this, InputActivity.class);
        intent.putExtra(InputActivity.EMAIL, emailUser.getText().toString());
        startActivity(intent);

    }
}