package com.example.retrofitrecycleview.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofitrecycleview.R;
import com.example.retrofitrecycleview.models.news.Article;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;


public class ViewFragment extends Fragment {
    private ImageView newsImage;
    private TextView newsTitle;
    private TextView newsDescription;
    private TextView newsPublishedAt;
    private TextView newsSources;
    private Button saveNewsButton;


    private Article mArticles;



    public ViewFragment() {
        // Required empty public constructor
    }


    //News instance method is used instead of a constructor and returns a new
    //instance of the news fragment.
    //The parceler library is used to add news article object to our bundle and set the bundle as the argument
    //for the new article fragment to allow data when a new instance of the fragment is crewated.
    public static ViewFragment newInstance(Article article){
        ViewFragment viewFragment = new ViewFragment();
        Bundle args = new Bundle();
        args.putParcelable("article", Parcels.wrap(article));
        viewFragment.setArguments(args);
        return viewFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        assert getArguments() != null;
        mArticles = Parcels.unwrap(getArguments().getParcelable("article"));


        }
        
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_view, container, false);

       newsImage = view.findViewById(R.id.fragment_news_image);
       newsTitle = view.findViewById(R.id.fragment_news_title);
       newsDescription = view.findViewById(R.id.fragment_news_description);
       newsPublishedAt = view.findViewById(R.id.fragment_news_publishedAt);
       newsSources = view.findViewById(R.id.fragment_news_sources);
       saveNewsButton = view.findViewById(R.id.saveRestaurantButton);

       newsTitle.setText(mArticles.getTitle());
       newsDescription.setText(mArticles.getDescription());
       newsPublishedAt.setText(mArticles.getPublishedAt());
       newsSources.setText(mArticles.getSource().toString());
        Picasso.get().load(mArticles.getUrlToImage()).into(newsImage);

        saveNewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        if (view == saveNewsButton){
                            DatabaseReference databaseReference = FirebaseDatabase
                                    .getInstance()
                                    .getReference("news");
                            databaseReference.push().setValue(mArticles);
                            Toast.makeText(getContext(), "saved", Toast.LENGTH_SHORT).show();

                        }

                    }

        });


        return view;



    }





}