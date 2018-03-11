package com.udacity.moviesapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.udacity.moviesapp.data.MovieContract.MovieEntry;

/**
 * Created by The Dev Wolf on 07-03-2018.
 */

public class MovieDbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "movie.db";
    public static final int DB_VERSION = 2;

    public MovieDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQLITE_CREATE_DB_PETS = "CREATE TABLE " + MovieEntry.TABLE_NAME + "(" +
                MovieEntry._id + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                MovieEntry.TITLE_COLUMN + " TEXT NOT NULL ," +
                MovieEntry.RELEASE_DATA_COLUMN + " TEXT NOT NULL ," +
                MovieEntry.OVERVIEW_COLUMN + " TEXT NOT NULL ," +
                MovieEntry.RATING_COLUMN + " REAL NOT NULL ," +
                MovieEntry.THUMBNAIL_COLUMN + " TEXT NOT NULL ," +
                MovieEntry.POSTER_COLUMN + " TEXT NOT NULL"
                + ");";

        sqLiteDatabase.execSQL(SQLITE_CREATE_DB_PETS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MovieEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
