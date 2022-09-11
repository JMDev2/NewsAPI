package com.example.retrofitrecycleview;

import static com.example.retrofitrecycleview.Constants.NEWS_API_KEY;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofitrecycleview.models.Article;
import com.example.retrofitrecycleview.models.NewsAdapter;
import com.example.retrofitrecycleview.models.NewsResponse;
import com.example.retrofitrecycleview.newtork.NewsApi;
import com.example.retrofitrecycleview.newtork.NewsClient;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    NewsAdapter adapter;
    List<Article> newsArticle = new ArrayList<>();

    TextView mUnderline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);


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

}



