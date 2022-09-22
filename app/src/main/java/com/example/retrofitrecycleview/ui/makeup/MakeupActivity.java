package com.example.retrofitrecycleview.ui.makeup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.retrofitrecycleview.Adapter.MakeupAdapter;
import com.example.retrofitrecycleview.R;
import com.example.retrofitrecycleview.models.makeup.MakeupResponse;
import com.example.retrofitrecycleview.newtork.makeup.MakeUpClient;
import com.example.retrofitrecycleview.newtork.makeup.MakeupApi;
import com.example.retrofitrecycleview.ui.news.MainActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MakeupActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MakeupAdapter makeupAdapter;
    List<MakeupResponse> makeUp = new ArrayList<>();

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeup);


        recyclerView = findViewById(R.id.makeuprecycler);



        apiCall();
    }

    private void apiCall() {
        MakeupApi client = MakeUpClient.getClient();
        Call<List<MakeupResponse>> call = client.getMakeUp("maybelline");
        Log.d("activity", "error");
        call.enqueue(new Callback<List<MakeupResponse>>() {
            @Override
            public void onResponse(Call<List<MakeupResponse>> call, Response<List<MakeupResponse>> response) {
                if (response.isSuccessful()){

                    makeUp = response.body();

                    makeupAdapter = new MakeupAdapter(getApplicationContext(), makeUp);

                    Log.d("activity", "error");
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(layoutManager);

                    recyclerView.setHasFixedSize(true);
                    recyclerView.setAdapter(makeupAdapter);

                }
            }

            @Override
            public void onFailure(Call<List<MakeupResponse>> call, Throwable t) {
                Log.e("MakeupActivity", "error", t.fillInStackTrace());
                Toast.makeText(MakeupActivity.this, "Cannot fetch data" + t.getCause(),Toast.LENGTH_LONG).show();

            }
        });
    }
}