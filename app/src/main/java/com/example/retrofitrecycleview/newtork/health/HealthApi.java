package com.example.retrofitrecycleview.newtork.health;

import com.example.retrofitrecycleview.models.health.HealthResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HealthApi {
    @GET("search")
    Call<HealthResponse> getHealth (
            @Query("appId") String appId,
            @Query("appKey") String appKey,
            @Query("query") String query
    );

    }
