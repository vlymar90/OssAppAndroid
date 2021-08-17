package com.example.ossapp.requests;

import com.example.ossapp.dto.CityDto;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface CityRequest {
    // этот готов
    @GET("cities")
    Call<List<CityDto>> getCity(@Query("name") String name);}
