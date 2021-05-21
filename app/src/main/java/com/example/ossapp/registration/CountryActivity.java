package com.example.ossapp.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ossapp.R;
import com.example.ossapp.User.User;

import java.util.ArrayList;

public class CountryActivity extends AppCompatActivity {
     private EditText city;
     private String[] listCity;
     private ListView listViewCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        city = (EditText) findViewById(R.id.cityUser);
        listCity = getResources().getStringArray(R.array.city);
        listViewCity = (ListView) findViewById(R.id.listCity);

        city.addTextChangedListener(new TextWatcher(){

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){
                  String inputText = s.toString();
                  setListView(inputText);
            }

            @Override
            public void afterTextChanged(Editable editable) {

                // действия после того, как что то введено
                // editable - то, что введено. В строку - editable.toString()
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
        });

        listViewCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                TextView textView = (TextView) itemClicked;
                String strText = textView.getText().toString(); // получаем текст нажатого элемента
                city.setText(strText);
            }
        });
    }

    private void setListView(String text) {
        ArrayList<String> listSelectCity = new ArrayList<>();
        for(int i = 0; i < listCity.length; i++) {
            if(listCity[i].startsWith(text)) {
                listSelectCity.add(listCity[i]);
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listSelectCity);
        listViewCity.setAdapter(adapter);
    }

    public void nextActivity(View view) {
        Intent style = new Intent(this, FightingStylesActivity.class);
        startActivity(style);
    }
}