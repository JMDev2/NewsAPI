package com.example.retrofitrecycleview.newtork;

import com.example.retrofitrecycleview.models.NewsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("everything")
    Call<NewsResponse> getNews(
            @Query("q") String domains,
            @Query("language") String language,
            @Query("apiKey") String apiToken
            );

}
