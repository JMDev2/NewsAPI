package com.example.retrofitrecycleview.newtork.sports;

import com.example.retrofitrecycleview.models.sports.Sportsresponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SportsApi {
    @GET("all_sports.php")
    Call<Sportsresponse> getSport();
}
