package com.example.myapplication.modelview;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.directory.Directory;
import com.example.myapplication.model.Indonesia;

import java.util.List;

public class ModelViews extends ViewModel {
    private Directory directory;
    private MutableLiveData<List<Indonesia>> mutableLiveData;

    public void init(){
        if (mutableLiveData != null){
            mutableLiveData = null;
        }

        directory = Directory.getInstance();
        mutableLiveData = directory.getData("https://api.kawalcorona.com/");
    }

    public LiveData<List<Indonesia>> getData(){
        return mutableLiveData;
    }
}
