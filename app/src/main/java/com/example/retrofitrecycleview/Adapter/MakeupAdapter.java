package com.example.retrofitrecycleview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitrecycleview.R;
import com.example.retrofitrecycleview.models.makeup.MakeupResponse;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MakeupAdapter extends RecyclerView.Adapter<MakeupAdapter.MakeupViewHolder> {
    private Context context;
    private List<MakeupResponse> makeUp = new ArrayList<>();


    public MakeupAdapter(Context context, List<MakeupResponse> makeUp) {
        this.context = context;
        this.makeUp = makeUp;
    }

    @NonNull
    @Override
    public MakeupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.makeup, parent, false);
        MakeupViewHolder makeupViewHolder = new MakeupViewHolder(view, makeUp);
        return makeupViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MakeupViewHolder holder, int position) {
        holder.bindMakeUp(makeUp.get(position));

    }

    @Override
    public int getItemCount() {
        return makeUp.size();
    }

    public class MakeupViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView category;
        private TextView productName;
        private ImageView image;

        private Context context;
        private List<MakeupResponse> makeup = new ArrayList<>();


        public MakeupViewHolder(@NonNull View itemView, List<MakeupResponse> makeUp) {
            super(itemView);
            this.makeup = makeUp;
            context = itemView.getContext();

            name = itemView.findViewById(R.id.makeup_name);
            category = itemView.findViewById(R.id.makeup_category);
            productName = itemView.findViewById(R.id.makeup_product_type);
            image = itemView.findViewById(R.id.makeup_image);
        }

        public void bindMakeUp(MakeupResponse makeupResponse) {
            name.setText(makeupResponse.getName());
            category.setText(makeupResponse.getCategory());
            productName.setText(makeupResponse.getProductType());
            Picasso.get().load(makeupResponse.getImageLink()).into(image);
        }
    }
}
