package com.example.studyroomrentalsystem.Service.Interface;

import com.example.studyroomrentalsystem.Model.Request.LoginRequest;
import com.example.studyroomrentalsystem.Model.Response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AccountService {
    @POST("api/v1/auth/login")
    Call<LoginResponse> getTokenAuthen(@Body LoginRequest loginRequest);
}
