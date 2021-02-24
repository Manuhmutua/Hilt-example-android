package com.manuh.havacodinginterview.viewmodel;

import android.content.Context;
import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.manuh.havacodinginterview.model.Trip;
import com.manuh.havacodinginterview.repository.TripRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TripViewModel extends ViewModel {

    private static final String TAG = "TripViewModel";

    private TripRepository repository;
    private MutableLiveData<ArrayList<Trip>> tripListn = new MutableLiveData<>();
    private LiveData<List<Trip>> tripList = null;

    @ViewModelInject
    public TripViewModel(TripRepository repository) {
        this.repository = repository;
        tripList = repository.getTripsDB();
    }

    public LiveData<List<Trip>> getTripList() {
        return tripList;
    }

    public void getTrips(Context context) {
        repository.getTrips()
                .subscribeOn(Schedulers.io())
                .map(tripResponse -> {
                    ArrayList<Trip> list = tripResponse.getTrips();
                    repository.insertTrips(list);
                    return list;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> tripListn.setValue((ArrayList<Trip>) result),
                        error -> Log.e(TAG, "getTrips: " + error.getMessage()));
    }

}
