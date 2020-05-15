package com.example.myapplication.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {
    private static RetrofitApi instance;

    public static RetrofitApi getInstance() {
        if (instance != null) {
            instance = null;
        }

        instance = new RetrofitApi();

        return instance;
    }

    public Retrofit getRequest(String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
