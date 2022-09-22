package com.example.retrofitrecycleview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitrecycleview.R;
import com.example.retrofitrecycleview.models.weather.Location;

import java.util.ArrayList;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {
    private Context context;
    private List<Location> mLocation = new ArrayList<>();


    public WeatherAdapter(Context context, List<Location> mLocation) {
        this.context = context;
        this.mLocation = mLocation;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather,parent,false);
        WeatherViewHolder weatherViewHolder = new WeatherViewHolder(view, mLocation);
        return weatherViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.WeatherViewHolder holder, int position) {
        holder.bindWeather(mLocation.get(position));

    }

    @Override
    public int getItemCount() {
        return mLocation.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView name;
        private TextView country;
        private TextView region;
        private TextView latitude;
        private TextView longitude;
        private TextView timezone;
        private TextView locationtime;

        private Context context;
        private List<Location> mLocation = new ArrayList<>();



        public WeatherViewHolder(@NonNull View itemView, List<Location> mLocation) {
            super(itemView);
            this.mLocation = mLocation;
            context = itemView.getContext();
            name = itemView.findViewById(R.id.weather_name);
            country = itemView.findViewById(R.id.weather_country);
            region = itemView.findViewById(R.id.weather_region);
            latitude = itemView.findViewById(R.id.weather_lat);
            longitude = itemView.findViewById(R.id.weather_lon);
            timezone = itemView.findViewById(R.id.weather_timezone);
            locationtime = itemView.findViewById(R.id.weather_locationtime);

            itemView.setOnClickListener(this);

        }

        public void bindWeather(Location location) {
            name.setText(location.getName());
            country.setText(location.getCountry());
            region.setText(location.getRegion());
            latitude.setText(location.getLat());
            longitude.setText(location.getLon());
            timezone.setText(location.getTimezoneId());
            locationtime.setText(location.getLocaltime());
        }

        @Override
        public void onClick(View view) {

        }
    }
}
