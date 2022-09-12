package com.example.retrofitrecycleview.newtork;

import com.example.retrofitrecycleview.models.weather.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeaatherApi {
    //    WeatherStack ApI

    @GET("current")
    Call<WeatherResponse> getWeather(
            @Query("access_key") String access_key,
            @Query("query") String query
    );
}
