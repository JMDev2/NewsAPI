package com.example.retrofitrecycleview.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HealthAdapter extends RecyclerView.Adapter<HealthAdapter.HealthViewHolder> {
    private Context context;

    @NonNull
    @Override
    public HealthAdapter.HealthViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HealthAdapter.HealthViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class HealthViewHolder extends RecyclerView.ViewHolder {
        public HealthViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
