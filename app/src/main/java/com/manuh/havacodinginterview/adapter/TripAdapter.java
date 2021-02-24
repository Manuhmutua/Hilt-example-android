package com.manuh.havacodinginterview.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.manuh.havacodinginterview.R;
import com.manuh.havacodinginterview.TripDetailsActivity;
import com.manuh.havacodinginterview.model.Trip;

import java.util.ArrayList;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripViewHolder> {
    private ArrayList<Trip> mTripList;

    static class TripViewHolder extends RecyclerView.ViewHolder {
        TextView tripStartTime;
        TextView tripFinalCost;
        TextView pickupLocation;
        TextView dropoffLocation;
        RatingBar ratingBar;
        TextView tripStatus;
        ImageView tripStatusImage;
        CardView cardView;

        public TripViewHolder(View itemView) {
            super(itemView);
            tripStartTime = itemView.findViewById(R.id.trip_start_time);
            tripFinalCost = itemView.findViewById(R.id.trip_final_cost);
            pickupLocation = itemView.findViewById(R.id.pickup_location);
            dropoffLocation = itemView.findViewById(R.id.dropoff_location);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            tripStatus = itemView.findViewById(R.id.trip_status);
            tripStatusImage = itemView.findViewById(R.id.trip_status_image);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }

    public TripAdapter(ArrayList<Trip> tripList) {
        mTripList = tripList;
    }

    @Override
    public TripViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trip,
                parent, false);
        TripViewHolder evh = new TripViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(TripViewHolder holder, int position) {
        Trip currentItem = mTripList.get(position);
        holder.tripStartTime.setText(currentItem.getPickupDate());
        holder.tripFinalCost.setText(currentItem.getCost() + " " + currentItem.getCostUnit());
        holder.pickupLocation.setText(currentItem.getPickupLocation());
        holder.dropoffLocation.setText(currentItem.getDropoffLocation());
        holder.ratingBar.setRating(currentItem.getDriverRating());
        if (currentItem.getStatus().equals("COMPLETED")) {
            holder.tripStatus.setText("COMPLETED");
            holder.tripStatus.setTextColor(Color.parseColor("#000000"));
            Glide.with(holder.itemView).load(R.drawable.ic_check_black_24dp).into(holder.tripStatusImage);
        } else if (currentItem.getStatus().equals("CANCELED")) {
            holder.tripStatus.setText("CANCELED");
            holder.tripStatus.setTextColor(Color.parseColor("#FF0000"));
            Glide.with(holder.itemView).load(R.drawable.ic_cancel).into(holder.tripStatusImage);
        }

        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), TripDetailsActivity.class);
            intent.putExtra("trip", currentItem);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mTripList.size();
    }

}
