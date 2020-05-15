package com.example.myapplication.directory;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.api.RetrofitApi;
import com.example.myapplication.api.RetrofitJsonApi;
import com.example.myapplication.model.Indonesia;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Directory {
    private static Directory instance;

    public static Directory getInstance(){
        if (instance != null) {
            instance = null;
        }

        instance = new Directory();

        return instance;
    }

    public MutableLiveData<List<Indonesia>> getData(String url){
        final MutableLiveData<List<Indonesia>> mutableLiveData = new MutableLiveData<>();
        RetrofitJsonApi api = RetrofitApi.getInstance().getRequest(url).create(RetrofitJsonApi.class);

        Call<List<Indonesia>> call  = api.getIndonesia();

        call.enqueue(new Callback<List<Indonesia>>() {
            @Override
            public void onResponse(Call<List<Indonesia>> call, Response<List<Indonesia>> response) {
                List<Indonesia> indonesia = response.body();

                if (indonesia != null) {
                    mutableLiveData.setValue(indonesia);
                }else{
                    Log.d("Kesalahan","Terjadi Kesalahan");
                }
            }

            @Override
            public void onFailure(Call<List<Indonesia>> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });

        return mutableLiveData;
    }
}
