package com.example.retrofitrecycleview.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitrecycleview.R;
import com.example.retrofitrecycleview.models.sports.Sport;
import com.example.retrofitrecycleview.ui.sport.DisplaySportActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class SportAdapter extends RecyclerView.Adapter <SportAdapter.SportViewHolder> {
    private Context context;
    private List<Sport> sport = new ArrayList<>();


    public SportAdapter(Context context, List<Sport> sport) {
        this.context = context;
        this.sport = sport;
    }

    @NonNull
    @Override
    public SportAdapter.SportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sportlayout, parent, false);
        SportViewHolder sportViewHolder = new SportViewHolder(view, sport);
        return sportViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull SportAdapter.SportViewHolder holder, int position) {
        holder.bindSport(sport.get(position));

    }

    @Override
    public int getItemCount() {
        return sport.size();
    }


    public class SportViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView sportImage;
        private TextView sporttype;
        private TextView sportFomart;

        private Context context;
        private List<Sport> mSport = new ArrayList<>();


        public SportViewHolder(@NonNull View itemView, List<Sport> sport) {
            super(itemView);
            this.mSport = sport;
            context = itemView.getContext();
            sportImage = itemView.findViewById(R.id.sport_image);
            sporttype = itemView.findViewById(R.id.sport_type);
            sportFomart = itemView.findViewById(R.id.sport_format);

            itemView.setOnClickListener(this);



        }

        public void bindSport(Sport sport) {
            sporttype.setText(sport.getStrSport());
            sportFomart.setText(sport.getStrFormat());
            Picasso.get().load(sport.getStrSportThumb()).into(sportImage);
        }

        @Override
        public void onClick(View view) {
            int itemPosition = getAdapterPosition();
            Intent intent = new Intent(context, DisplaySportActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("sport", Parcels.wrap(mSport.get(itemPosition)));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(intent);

        }
    }
}
