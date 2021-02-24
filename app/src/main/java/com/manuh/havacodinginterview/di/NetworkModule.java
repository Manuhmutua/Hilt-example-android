package com.manuh.havacodinginterview.di;

import com.manuh.havacodinginterview.source.api.ApiInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(ApplicationComponent.class)
public class NetworkModule {
    @Provides
    @Singleton
    public static ApiInterface provideApi() {
        return new Retrofit.Builder()
                .baseUrl("https://hr.hava.bz/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(ApiInterface.class);
    }
}
