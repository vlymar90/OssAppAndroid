package com.example.ossapp.requests;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofit {
    private static final String URL = "https://ossappmortialarts.herokuapp.com/api/v1/";
    private static Retrofit instance;


    private MyRetrofit() {
    }

    public static Retrofit getInstance() {
        if (instance == null) {
            return new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        } else {
            return instance;
        }
    }
}

