package com.example.studyroomrentalsystem.Service.Implement;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {
    Gson gson = new GsonBuilder()
            .setDateFormat("dd-MM-yyyy:mm:ss")
            .create();
    private static final String baseURL = "https://studyroomrental.azurewebsites.net/";
    private static Retrofit retrofit;
    public static  Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return  retrofit;
    }
}
