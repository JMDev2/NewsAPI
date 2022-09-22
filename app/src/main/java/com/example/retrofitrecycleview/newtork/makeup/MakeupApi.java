package com.example.retrofitrecycleview.newtork.makeup;

import com.example.retrofitrecycleview.models.makeup.MakeupResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MakeupApi {
    @GET("products.json")
    Call<List<MakeupResponse>> getMakeUp(
            @Query("brand") String brand

    );


    }
