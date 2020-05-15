package com.example.myapplication.api;

import com.example.myapplication.model.Indonesia;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitJsonApi {
    @GET("indonesia")
    Call<List<Indonesia>> getIndonesia();
}
