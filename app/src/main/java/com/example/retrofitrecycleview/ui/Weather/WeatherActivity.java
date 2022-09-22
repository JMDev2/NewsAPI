package com.example.retrofitrecycleview.ui.Weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.retrofitrecycleview.Adapter.NewsAdapter;
import com.example.retrofitrecycleview.Adapter.WeatherAdapter;
import com.example.retrofitrecycleview.R;
import com.example.retrofitrecycleview.models.weather.Location;
import com.example.retrofitrecycleview.models.weather.WeatherResponse;
import com.example.retrofitrecycleview.newtork.Constants;
import com.example.retrofitrecycleview.newtork.weather.WeaatherApi;
import com.example.retrofitrecycleview.newtork.weather.WeatherClient;
import com.example.retrofitrecycleview.ui.news.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends AppCompatActivity {
    Button button;
    private List<Location> mLocation;
    RecyclerView recyclerView;
    WeatherAdapter weatherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        recyclerView = findViewById(R.id.weather_recycler);

        apiCall();



    }

    private void apiCall() {
        WeaatherApi client = WeatherClient.getClient();
        Call<List<WeatherResponse>> call = client.getWeather(Constants.WEATHER_API_KEY, "Nairobi");
        call.enqueue(new Callback<List<WeatherResponse>>() {
            @Override
            public void onResponse(Call<List<WeatherResponse>> call, Response<List<WeatherResponse>> response) {
//                mLocation = response.body();
                weatherAdapter = new WeatherAdapter(getApplicationContext(), mLocation);

                recyclerView.setAdapter(weatherAdapter);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setHasFixedSize(true);
            }

            @Override
            public void onFailure(Call<List<WeatherResponse>> call, Throwable t) {

            }
        });
    }
}