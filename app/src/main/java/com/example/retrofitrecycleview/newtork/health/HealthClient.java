package com.example.retrofitrecycleview.newtork.health;

import com.example.retrofitrecycleview.newtork.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HealthClient {
    private static Retrofit retrofit = null;

    public static HealthApi getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(Constants.HEALTH_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(HealthApi.class);
    }
}

