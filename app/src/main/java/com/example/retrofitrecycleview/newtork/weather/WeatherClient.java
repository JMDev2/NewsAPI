package com.example.retrofitrecycleview.newtork.weather;

import com.example.retrofitrecycleview.newtork.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherClient {
    public static Retrofit retrofit = null;

    public static WeaatherApi getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(Constants.WEATHER_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(WeaatherApi.class);
    }


}

