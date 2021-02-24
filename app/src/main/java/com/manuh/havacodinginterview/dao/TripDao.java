package com.manuh.havacodinginterview.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.manuh.havacodinginterview.model.Trip;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface TripDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTrip(ArrayList<Trip> trips);

    @Query("SELECT * FROM trips_table")
    LiveData<List<Trip>> getTrips();

    @Query("DELETE FROM trips_table")
    void deleteAll();
}
