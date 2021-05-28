package com.example.ossapp.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
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
import com.example.ossapp.SearchActivity;
import com.example.ossapp.User.User;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class CountryActivity extends AppCompatActivity {
    private EditText city;
    private String[] listCity;
    private ListView listViewCity;
    private int acivityId;
    private String wantedCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        city = (EditText) findViewById(R.id.cityUser);
        listCity = getResources().getStringArray(R.array.city);
        listViewCity = (ListView) findViewById(R.id.listCity);

        Intent cityFilter = getIntent();
        if (cityFilter.hasExtra("id"))
            acivityId = getIntent().getIntExtra("id", 0);

        city.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String inputText = s.toString();
                setListView(inputText);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Retrofit не готов
                /*AsyncTask.execute(new Runnable() {
                    URL url = null;
                    @Override
                    public void run() {
                        Uri newCity = Uri.parse("localhost").buildUpon()
                                .appendQueryParameter("name", editable.toString())
                                .build();
                        try {
                            url = new URL(newCity.toString());
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        try {
                            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                            InputStream in = urlConnection.getInputStream();
                            Scanner scanner = new Scanner(in);
                            city.setText(scanner.next());
                            urlConnection.disconnect();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });*/
                // действия после того, как что то введено
                // editable - то, что введено. В строку - editable.toString()
            }


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });

        listViewCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                TextView textView = (TextView) itemClicked;
                String strText = textView.getText().toString(); // получаем текст нажатого элемента
                city.setText(strText);
                wantedCity = strText;
            }
        });
    }

    private void setListView(String text) {
        ArrayList<String> listSelectCity = new ArrayList<>();
        for (int i = 0; i < listCity.length; i++) {
            if (listCity[i].startsWith(text)) {
                listSelectCity.add(listCity[i]);
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listSelectCity);
        listViewCity.setAdapter(adapter);
    }

    public void nextActivity(View view) {
        if (acivityId == 1) {
            Intent style = new Intent(this, FightingStylesActivity.class);
            startActivity(style);
        } else if (acivityId == 2) {
            Intent search = new Intent(this, SearchActivity.class);
            search.putExtra("city", wantedCity);
            startActivity(search);
        }
    }
}