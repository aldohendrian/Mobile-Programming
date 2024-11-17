package com.example.infopariwisataisleventurer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TouristPlaceAdapter extends RecyclerView.Adapter<TouristPlaceAdapter.ViewHolder> {

    private List<TouristPlace> touristPlaces;
    private Context context;

    public TouristPlaceAdapter(List<TouristPlace> touristPlaces, Context context) {
        this.touristPlaces = touristPlaces;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView, locationTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.placeImage);
            nameTextView = itemView.findViewById(R.id.placeName);
            locationTextView = itemView.findViewById(R.id.placeLocation);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tourist_place, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TouristPlace place = touristPlaces.get(position);

        holder.nameTextView.setText(place.getName());
        holder.locationTextView.setText(place.getLocation());
        holder.imageView.setImageResource(place.getImageResourceId());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("name", place.getName());
            intent.putExtra("location", place.getLocation());
            intent.putExtra("description", place.getDescription());
            intent.putExtra("imageResourceId", place.getImageResourceId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return touristPlaces.size();
    }

    // Metode untuk memperbarui data dalam adapter
    public void updateList(List<TouristPlace> newList) {
        touristPlaces = newList;
        notifyDataSetChanged();
    }
}
