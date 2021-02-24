package com.manuh.havacodinginterview.di;

import android.app.Application;

import androidx.room.Room;

import com.manuh.havacodinginterview.dao.TripDao;
import com.manuh.havacodinginterview.source.database.Database;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class DatabaseModule {

    @Provides
    @Singleton
    public static Database provideDB(Application application) {
        return Room.databaseBuilder(application, Database.class, "Trips Database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    public static TripDao providePokeDao(Database database) {
        return database.tripDao();
    }
}
