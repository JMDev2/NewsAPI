package com.example.retrofitrecycleview.newtork;

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



    @GET("all_sports.php")
    Call<Sportsresponse> getSport();


//    WeatherStack ApI

    @GET("current")
    Call<WeatherResponse> getWeather(
            @Query("access_key") String access_key,
            @Query("query") String query
    );

}
