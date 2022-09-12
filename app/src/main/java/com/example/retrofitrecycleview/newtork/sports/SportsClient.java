package com.example.retrofitrecycleview.newtork.sports;

import com.example.retrofitrecycleview.newtork.Constants;
import com.example.retrofitrecycleview.newtork.generalnews.NewsApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SportsClient {
    private static Retrofit retrofit = null;

    public static SportsApi getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(Constants.SPORT_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(SportsApi.class);
    }
}
