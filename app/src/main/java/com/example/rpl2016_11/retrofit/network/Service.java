package com.example.rpl2016_11.retrofit.network;

import com.example.rpl2016_11.retrofit.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("3/movie/now_playing?api_key=05d24d1094bc376832434c74ca08824f&language=en-US")
    Call<Result>result();
}
