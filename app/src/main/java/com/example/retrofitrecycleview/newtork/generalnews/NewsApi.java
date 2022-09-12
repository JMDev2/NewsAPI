package com.example.retrofitrecycleview.newtork.generalnews;

import com.example.retrofitrecycleview.models.news.NewsResponse;
import com.example.retrofitrecycleview.models.sports.Sportsresponse;
import com.example.retrofitrecycleview.models.weather.WeatherResponse;

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
