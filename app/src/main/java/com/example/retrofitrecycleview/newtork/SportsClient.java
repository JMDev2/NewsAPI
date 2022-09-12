package com.example.retrofitrecycleview.newtork;

import com.example.retrofitrecycleview.models.sports.Sport;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SportsClient {
    private static Retrofit retrofit = null;

    public static NewsApi getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(Constants.SPORT_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(NewsApi.class);
    }
}
