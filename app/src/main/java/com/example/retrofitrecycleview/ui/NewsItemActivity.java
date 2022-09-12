package com.example.retrofitrecycleview.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.retrofitrecycleview.R;
import com.example.retrofitrecycleview.models.news.Article;

import org.parceler.Parcels;

public class NewsItemActivity extends AppCompatActivity {
    private ViewFragment viewFragment;

    Article mArticles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_item);

        mArticles = Parcels.unwrap(getIntent().getParcelableExtra("article"));



        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container, ViewFragment.newInstance(mArticles))
                .commit();

    }
}