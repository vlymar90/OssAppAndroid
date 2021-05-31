package com.example.ossapp.registration;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
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
import com.example.ossapp.dto.CityDto;
import com.example.ossapp.requests.CityRequest;
import com.example.ossapp.requests.MyRetrofit;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryActivity extends AppCompatActivity {
    private EditText city;
    private ListView listViewCity;
    private int acivityId;
    private String wantedCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        city = (EditText) findViewById(R.id.cityUser);
        listViewCity = (ListView) findViewById(R.id.listCity);
        Intent cityFilter = getIntent();
        if (cityFilter.hasExtra("id"))
            acivityId = getIntent().getIntExtra("id", 0);

        city.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String inputText = s.toString();
                CityRequest request = MyRetrofit.getInstance().create(CityRequest.class);
                Call<List<CityDto>> call = request.getCity(inputText);
                call.enqueue(new Callback<List<CityDto>>() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onResponse(Call<List<CityDto>> call, Response<List<CityDto>> response) {
                        List<CityDto> cityDtoList = response.body();
                        assert cityDtoList != null;
                        setListView(cityDtoList);
                    }

                    @Override
                    public void onFailure(Call<List<CityDto>> call, Throwable t) {
                    }
                });
            }
//                setListView(inputText);


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

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setListView(List<CityDto> cityDtoList) {
        List<String> listSelectCity = cityDtoList.stream().map(CityDto::getName).collect(Collectors.toList());
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