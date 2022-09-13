package com.example.retrofitrecycleview.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitrecycleview.models.news.Article;
import com.example.retrofitrecycleview.ui.NewsItemActivity;
import com.example.retrofitrecycleview.R;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private Context context;
    private List<Article> mNews = new ArrayList<>();

    public NewsAdapter(Context context, List<Article> mNews) {
        this.context = context;
        this.mNews = mNews;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.newsitems, parent,false);
        NewsViewHolder newsViewHolder = new NewsViewHolder(view, (ArrayList<Article>) mNews);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.bindNews(mNews.get(position));

    }

    @Override
    public int getItemCount() {
        return mNews.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView newsTitle;
        private TextView newsLink;
        private TextView newsAuthor;
        private TextView newsPublishedat;
        private ImageView newsImage;
        private Button saveNews;

        private Context context;
        private ArrayList<Article> mNews = new ArrayList<>();

        public NewsViewHolder(@NonNull View itemView, ArrayList<Article> mNews) {
            super(itemView);
            this.mNews = mNews;
            context = itemView.getContext();
            newsTitle = itemView.findViewById(R.id.news_title);
            newsLink = itemView.findViewById(R.id.news_link);
            newsAuthor = itemView.findViewById(R.id.news_author);
            newsImage = itemView.findViewById(R.id.news_image);
            saveNews = itemView.findViewById(R.id.saveRestaurantButton);

            itemView.setOnClickListener(this);


        }

        public void bindNews(Article article) {
            newsTitle.setText(article.getTitle());
            newsLink.setText(article.getUrl());
            newsAuthor.setText(article.getAuthor());
            Picasso.get().load(article.getUrlToImage()).into(newsImage);
        }

        @Override
        public void onClick(View view) {

            int itemPosition = getAdapterPosition();
            Intent intent = new Intent(context, NewsItemActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("article", Parcels.wrap(mNews.get(itemPosition)));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(intent);

        }
    }
}
