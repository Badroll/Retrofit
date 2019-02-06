package com.example.rpl2016_11.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.rpl2016_11.retrofit.model.Result;
import com.example.rpl2016_11.retrofit.network.Service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    String url;
    Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = "https://api.themoviedb.org/";
        retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        Service service = retrofit.create(Service.class);
        Call<Result> resultCall= service.result();
        resultCall.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                System.out.println("kmj"+response.body());
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                System.out.println("eror"+t.getMessage());
            }
        });
    }
}
