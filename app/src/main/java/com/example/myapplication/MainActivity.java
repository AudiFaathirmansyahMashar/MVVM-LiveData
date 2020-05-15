package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.model.Indonesia;
import com.example.myapplication.modelview.ModelViews;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private ModelViews viewModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);

        viewModels = new ViewModelProvider(this).get(ModelViews.class);
        viewModels.init();
        viewModels.getData().observe(this, new Observer<List<Indonesia>>() {
            @Override
            public void onChanged(List<Indonesia> indonesias) {
                for (Indonesia indonesia : indonesias) {
                    text.setText("Lokasi : "+ indonesia.getName() +"\n\n\nPositif : "+ indonesia.getPositif()+"\n\n\n Meninggal : " + indonesia.getMeninggal() +"\n\n\n Sembuh : "+indonesia.getSembuh());
                }
            }
        });
    }
}
