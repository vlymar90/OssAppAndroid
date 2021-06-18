package com.example.ossapp.requests;

import com.example.ossapp.dto.UserDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserRequest {
    @POST("users")
    Call<UserDto> saveProfile(@Body UserDto userDto);
}
