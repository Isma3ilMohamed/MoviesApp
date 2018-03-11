package com.udacity.moviesapp.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by The Dev Wolf on 10-03-2018.
 */

public class MovieProvider extends ContentProvider {

    public static final int MOVIE = 100;
    public static final int MOVIE_ID = 101;

    public static final UriMatcher sURI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    private MovieDbHelper dbHelper;


    static {
        sURI_MATCHER.addURI(MovieContract.CONTENT_AUTHORITY, MovieContract.PATH_PETS, MOVIE);
        sURI_MATCHER.addURI(MovieContract.CONTENT_AUTHORITY, MovieContract.PATH_PETS + "/#", MOVIE_ID);
    }


    @Override
    public boolean onCreate() {
        dbHelper = new MovieDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection,
                        @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = null;
        int match = sURI_MATCHER.match(uri);

        switch (match) {
            case MOVIE:
                cursor = db.query(MovieContract.MovieEntry.TABLE_NAME,
                        projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case MOVIE_ID:
                selection = MovieContract.MovieEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = db.query(MovieContract.MovieEntry.TABLE_NAME,
                        projection, selection, selectionArgs, null, null, sortOrder);
                break;

        }


        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long idInserted = 0;
        Uri uriInserted;
        int match = sURI_MATCHER.match(uri);

        switch (match) {
            case MOVIE:
                idInserted = db.insert(MovieContract.MovieEntry.TABLE_NAME, null, contentValues);
                if (idInserted > 0) {
                    uriInserted = Uri.parse(MovieContract.MovieEntry._id);
                } else {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                break;
            default:
                throw new UnsupportedOperationException("Error on uri" + uri);

        }
        getContext().getContentResolver().notifyChange(uri, null);
        return uriInserted;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int match = sURI_MATCHER.match(uri);
        int idDeleted;
        if (selection == null) {
            selection = "1";
        }

        switch (match) {
            case MOVIE:
                idDeleted = db.delete(MovieContract.MovieEntry.TABLE_NAME, selection, selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException("Error on uri" + uri);

        }

        if (idDeleted != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return idDeleted;
    }

    /*need not to use update because i can't edit on data ;)*/

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
