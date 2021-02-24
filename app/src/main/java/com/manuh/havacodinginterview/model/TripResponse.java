package com.manuh.havacodinginterview.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TripResponse {

    @SerializedName("trips")
    private ArrayList<Trip> trips;

    public ArrayList<Trip> getTrips() {
        return trips;
    }

    public void setTrips(ArrayList<Trip> trips) {
        this.trips = trips;
    }
}
