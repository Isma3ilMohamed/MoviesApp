package com.udacity.moviesapp;

import android.app.Application;
import android.content.Intent;

import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

/**
 * Created by The Dev Wolf on 11-03-2018.
 */

public class MoviesApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        //--------offline capabilities for picasso
        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttpDownloader(this, Integer.MAX_VALUE));
        Picasso build = builder.build();
        //build.setIndicatorsEnabled(true);
        build.setLoggingEnabled(true);
        Picasso.setSingletonInstance(build);

    }
}
