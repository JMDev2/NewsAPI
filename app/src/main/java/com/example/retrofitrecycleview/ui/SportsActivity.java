package com.example.retrofitrecycleview.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.retrofitrecycleview.R;
import com.example.retrofitrecycleview.models.sports.Sportsresponse;
import com.example.retrofitrecycleview.newtork.sports.SportsClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SportsActivity extends AppCompatActivity {

    Button button;
    private List<Sportsresponse> sports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

        Call<Sportsresponse> call = SportsClient.getClient().getSport();

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call.enqueue(new Callback<Sportsresponse>() {
                    @Override
                    public void onResponse(Call<Sportsresponse> call, Response<Sportsresponse> response) {

                    }

                    @Override
                    public void onFailure(Call<Sportsresponse> call, Throwable t) {
                        Intent intent = new Intent(SportsActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

    }
}