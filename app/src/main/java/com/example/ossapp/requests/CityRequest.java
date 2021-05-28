package com.example.ossapp.requests;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CityRequest {
    // не готов
    @GET("name")
    Call<Response> getProduct(@Path("id") long id);
}
