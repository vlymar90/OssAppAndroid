package com.example.ossapp.registration;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
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
import com.example.ossapp.dto.UserDto;
import com.example.ossapp.dto.CityDto;
import com.example.ossapp.requests.CityRequest;
import com.example.ossapp.requests.MyRetrofit;
import java.util.List;
import java.util.stream.Collectors;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryActivity extends AppCompatActivity {
    private EditText city;
    private ListView listViewCity;
    private int activityId;
    private String wantedCity;
    private List<CityDto> cityDtoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        city = (EditText) findViewById(R.id.cityUser);
        listViewCity = (ListView) findViewById(R.id.listCity);
        Intent cityFilter = getIntent();
        if (cityFilter.hasExtra("id"))
            activityId = getIntent().getIntExtra("id", 0);

        city.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String inputText = s.toString();
                if (inputText.length() >= 3) {
                    CityRequest request = MyRetrofit.getInstance().create(CityRequest.class);
                    Call<List<CityDto>> call = request.getCity(inputText);
                    call.enqueue(new Callback<List<CityDto>>() {
                        @RequiresApi(api = Build.VERSION_CODES.N)
                        @Override
                        public void onResponse(Call<List<CityDto>> call, Response<List<CityDto>> response) {
                            cityDtoList = response.body();
                            assert cityDtoList != null;
                            setListView(cityDtoList);
                        }

                        @Override
                        public void onFailure(Call<List<CityDto>> call, Throwable t) {}
                    });
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }});

        listViewCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                TextView textView = (TextView) itemClicked;
                String strText = textView.getText().toString(); // получаем текст нажатого элемента
                city.setText(strText);
                for (int i = 0; i < cityDtoList.size(); i++) {
                    if(cityDtoList.get(i).getName().equals(strText)) {
                        UserDto.getInstance().setCity(cityDtoList.get(i).getId());
                        break;
                    }

                }
               wantedCity = strText;   // Это пока под вопросом
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
        if (activityId == 1) {
            Intent style = new Intent(this, FightingStylesActivity.class);
            startActivity(style);
        } else if (activityId == 2) {
            Intent search = new Intent(this, SearchActivity.class);
            search.putExtra("city", wantedCity);
            startActivity(search);
        }
    }
}