package com.manuh.havacodinginterview.source.database;

import androidx.room.RoomDatabase;

import com.manuh.havacodinginterview.dao.TripDao;
import com.manuh.havacodinginterview.model.Trip;

@androidx.room.Database(entities = {Trip.class}, version = 2, exportSchema = false)
public abstract class Database extends RoomDatabase {
    public abstract TripDao tripDao();
}
