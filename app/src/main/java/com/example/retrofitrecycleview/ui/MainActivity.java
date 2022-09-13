package com.example.retrofitrecycleview.ui;

import static com.example.retrofitrecycleview.newtork.Constants.NEWS_API_KEY;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofitrecycleview.R;
import com.example.retrofitrecycleview.models.news.Article;
import com.example.retrofitrecycleview.Adapter.NewsAdapter;
import com.example.retrofitrecycleview.models.news.NewsResponse;
import com.example.retrofitrecycleview.newtork.generalnews.NewsApi;
import com.example.retrofitrecycleview.newtork.generalnews.NewsClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    NewsAdapter adapter;
    List<Article> newsArticle = new ArrayList<>();


    //click images
    ImageView openSports;
    ImageView openHealth;
    ImageView openEnter;

    TextView mUnderline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);

        //click images
        openSports = findViewById(R.id.sports_news);
        openHealth = findViewById(R.id.health_image);
        openEnter = findViewById(R.id.entertainment_image);


        openSports.setOnClickListener(this);
        openHealth.setOnClickListener(this);
        openEnter.setOnClickListener(this);


        apiCall();

    }

    private void apiCall() {
        NewsApi client = NewsClient.getClient();
        Call<NewsResponse> call = client.getNews("bitcoin","en", NEWS_API_KEY);
        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful() && response.body() != null){
                    newsArticle = response.body().getArticles();
                    adapter = new NewsAdapter(getApplicationContext(), newsArticle);

                    recyclerView.setAdapter(adapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setHasFixedSize(true);

                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Cannot fetch data",Toast.LENGTH_LONG).show();

            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view == openSports) {
            Intent intent = new Intent(MainActivity.this, SportsActivity.class);
            startActivity(intent);
        }
        if (view == openHealth) {
            Intent health = new Intent(MainActivity.this, HealthActivity.class);
            startActivity(health);
        }
        if (view == openEnter){
            Intent entertainment = new Intent(MainActivity.this, EntertainmentActivity.class);
            startActivity(entertainment);
        }

    }
}



