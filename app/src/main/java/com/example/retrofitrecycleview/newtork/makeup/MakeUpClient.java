package com.example.retrofitrecycleview.newtork.makeup;

import com.example.retrofitrecycleview.newtork.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MakeUpClient {
    private static Retrofit retrofit = null;

    public static MakeupApi getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(Constants.MAKEUP_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(MakeupApi.class);
    }
}

