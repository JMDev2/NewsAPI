package com.example.retrofitrecycleview.ui.sport;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.retrofitrecycleview.R;
import com.example.retrofitrecycleview.models.sports.Sport;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SportsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SportsFragment extends Fragment {
    private ImageView sportImage;
    private TextView sportTitle;
    private TextView sportDescription;

    private Sport mSport;


    public SportsFragment() {
        // Required empty public constructor
    }


    public static SportsFragment newInstance(Sport sport) {
        SportsFragment fragment = new SportsFragment();
        Bundle args = new Bundle();
        args.putParcelable("sport", Parcels.wrap(sport));
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        assert getArguments() != null;
        mSport = Parcels.unwrap(getArguments().getParcelable("sport"));

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sports, container, false);

        sportImage = view.findViewById(R.id.fragment_sports_image);
        sportTitle = view.findViewById(R.id.fragment_sports_title);
        sportDescription = view.findViewById(R.id.fragment_sports_description);
        sportDescription.setMovementMethod(new ScrollingMovementMethod());


        Picasso.get().load(mSport.getStrSportThumb()).into(sportImage);
        sportTitle.setText(mSport.getStrSport());
        sportDescription.setText(mSport.getStrSportDescription());


        return view;
    }

}