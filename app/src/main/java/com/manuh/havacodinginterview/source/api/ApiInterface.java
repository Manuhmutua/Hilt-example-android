package com.manuh.havacodinginterview.source.api;

import com.manuh.havacodinginterview.model.TripResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("trips/recent.json")
    Observable<TripResponse> getTrips();
}
