package com.example.retrofitrecycleview.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.retrofitrecycleview.R;
import com.example.retrofitrecycleview.models.health.HealthResponse;
import com.example.retrofitrecycleview.newtork.Constants;
import com.example.retrofitrecycleview.newtork.health.HealthClient;
import com.example.retrofitrecycleview.ui.news.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HealthActivity extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        Call<HealthResponse> call = HealthClient.getClient().getHealth(Constants.APP_ID, Constants.HEALTH_API_KEY, "query");

        text = findViewById(R.id.text1);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call.enqueue(new Callback<HealthResponse>() {
                    @Override
                    public void onResponse(Call<HealthResponse> call, Response<HealthResponse> response) {

                    }

                    @Override
                    public void onFailure(Call<HealthResponse> call, Throwable t) {

                    }
                });
                Intent intent = new Intent(HealthActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}