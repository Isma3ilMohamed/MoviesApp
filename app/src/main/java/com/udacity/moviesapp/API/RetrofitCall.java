package com.udacity.moviesapp.API;

import android.support.annotation.NonNull;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by The Dev Wolf on 07-03-2018.
 */

public class RetrofitCall {

    //return retrofit object to can call from anywhere

    @NonNull
    public static Retrofit getMovie() {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
}
