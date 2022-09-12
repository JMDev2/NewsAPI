package com.example.retrofitrecycleview.newtork.generalnews;

import com.example.retrofitrecycleview.newtork.Constants;
import com.example.retrofitrecycleview.newtork.generalnews.NewsApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsClient {
    private static Retrofit retrofit = null;

    public static NewsApi getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(NewsApi.class);

    }


}

