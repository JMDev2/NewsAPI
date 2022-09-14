package com.example.retrofitrecycleview.ui.sport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.retrofitrecycleview.R;
import com.example.retrofitrecycleview.models.sports.Sport;

import org.parceler.Parcels;

public class DisplaySportActivity extends AppCompatActivity {
    private SportsFragment sportsFragment;
    Sport mSport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_sport);

        mSport = Parcels.unwrap(getIntent().getParcelableExtra("sport"));



        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.sports_fragment_container, SportsFragment.newInstance(mSport))
                .commit();
    }
}