package com.example.retrofitrecycleview.ui.sport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofitrecycleview.Adapter.SportAdapter;
import com.example.retrofitrecycleview.R;
import com.example.retrofitrecycleview.models.sports.Sport;
import com.example.retrofitrecycleview.models.sports.Sportsresponse;
import com.example.retrofitrecycleview.newtork.sports.SportsApi;
import com.example.retrofitrecycleview.newtork.sports.SportsClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SportsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SportAdapter sportAdapter;
    private List<Sport> sports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

        recyclerView = findViewById(R.id.sport_recycler);

        Call<Sportsresponse> call = SportsClient.getClient().getSport();


        apiCall();


//
//
//        button = findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                call.enqueue(new Callback<Sportsresponse>() {
//                    @Override
//                    public void onResponse(Call<Sportsresponse> call, Response<Sportsresponse> response) {
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<Sportsresponse> call, Throwable t) {
//                        Intent intent = new Intent(SportsActivity.this, MainActivity.class);
//                        startActivity(intent);
//                    }
//                });
//            }
//        });

    }

    private void apiCall() {
        SportsApi client = SportsClient.getClient();
        Call<Sportsresponse> call = client.getSport();
        call.enqueue(new Callback<Sportsresponse>() {
            @Override
            public void onResponse(Call<Sportsresponse> call, Response<Sportsresponse> response) {
                if (response.isSuccessful() && response.body() != null){
                    sports = response.body().getSports();
                    sportAdapter = new SportAdapter(getApplicationContext(), sports);

                    recyclerView.setAdapter(sportAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setHasFixedSize(true);
                }
            }

            @Override
            public void onFailure(Call<Sportsresponse> call, Throwable t) {
                Toast.makeText(SportsActivity.this, "Cannot fetch data",Toast.LENGTH_LONG).show();

            }
        });
    }
}