package com.manuh.havacodinginterview.repository;

import androidx.lifecycle.LiveData;

import com.manuh.havacodinginterview.dao.TripDao;
import com.manuh.havacodinginterview.model.Trip;
import com.manuh.havacodinginterview.model.TripResponse;
import com.manuh.havacodinginterview.source.api.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class TripRepository {

    private TripDao tripDao;
    private ApiInterface apiInterface;

    @Inject
    public TripRepository(TripDao tripDao, ApiInterface apiInterface) {
        this.tripDao = tripDao;
        this.apiInterface = apiInterface;
    }

    public Observable<TripResponse> getTrips() {
        return apiInterface.getTrips();
    }

    public LiveData<List<Trip>> getTripsDB() {
        return tripDao.getTrips();
    }

    public void insertTrips(ArrayList<Trip> trips) {
        tripDao.insertTrip(trips);
    }

    public void deleteAll() {
        tripDao.deleteAll();
    }

}
