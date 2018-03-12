package com.udacity.moviesapp.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.udacity.moviesapp.R;
import com.udacity.moviesapp.adapter.MoviesAdapter;
import com.udacity.moviesapp.data.MovieContract;
import com.udacity.moviesapp.databinding.ActivityFavouriteBinding;
import com.udacity.moviesapp.model.Movie;

public class FavouriteActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<Cursor>, MoviesAdapter.MovieOnClickListener {

    //Declare Data Binding
    ActivityFavouriteBinding mFavouriteBinding;
    //declare movie adapter
    private MoviesAdapter adapter;
    //Declare Layout Manager for RV
    private GridLayoutManager layoutManager;
    //declare Key for recyclerview state
    private final String recyclerStateKey = "recycler_state";
    //declare Parcelable to store recycler view state
    private Parcelable recyclerViewStateParcelable = null;

    //declare bundle to store recycler view state key & parcelable
    private static Bundle mBundleRecyclerViewState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFavouriteBinding = DataBindingUtil.setContentView(this, R.layout.activity_favourite);

        getSupportLoaderManager().initLoader(0, null, FavouriteActivity.this);

        layoutManager = new GridLayoutManager(this, 2);

        adapter = new MoviesAdapter(this, this, null);


        mFavouriteBinding.rvFavourites.setLayoutManager(layoutManager);
        mFavouriteBinding.rvFavourites.setAdapter(adapter);

        setSupportActionBar(mFavouriteBinding.toolbarFavourite);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Favourite Movies");
        }


    }


    @Override
    protected void onPause() {
        super.onPause();
        mBundleRecyclerViewState = new Bundle();
        recyclerViewStateParcelable = mFavouriteBinding.rvFavourites.getLayoutManager().onSaveInstanceState();
        mBundleRecyclerViewState.putParcelable(recyclerStateKey, recyclerViewStateParcelable);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (mBundleRecyclerViewState != null) {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    recyclerViewStateParcelable = mBundleRecyclerViewState.getParcelable(recyclerStateKey);
                    mFavouriteBinding.rvFavourites.getLayoutManager().onRestoreInstanceState(recyclerViewStateParcelable);

                }
            }, 50);
        }

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

            layoutManager.setSpanCount(2);

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {

            layoutManager.setSpanCount(2);

        }
        mFavouriteBinding.rvFavourites.setLayoutManager(layoutManager);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, MovieContract.MovieEntry.CONTENT_URI, null,
                null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data != null) {
            adapter = new MoviesAdapter(this, this, data);
            mFavouriteBinding.rvFavourites.setAdapter(adapter);
        } else {
            Toast.makeText(getApplicationContext(), "No Favourite Movies", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    @Override
    public void onMovieClick(Movie.MovieDetail movieDetail) {

    }

    @Override
    public void onFavouriteMovieClick(Cursor cursor, int Position) {
        cursor.moveToPosition(Position);
        Intent intent = new Intent(FavouriteActivity.this, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("id", cursor.getString
                (cursor.getColumnIndex(MovieContract.MovieEntry._id)));
        bundle.putString("poster", cursor.getString
                (cursor.getColumnIndex(MovieContract.MovieEntry.POSTER_COLUMN)));
        bundle.putString("rate", String.valueOf(cursor.getDouble
                (cursor.getColumnIndex(MovieContract.MovieEntry.RATING_COLUMN))));
        bundle.putString("title", cursor.getString
                (cursor.getColumnIndex(MovieContract.MovieEntry.TITLE_COLUMN)));
        bundle.putString("releaseData", cursor.getString
                (cursor.getColumnIndex(MovieContract.MovieEntry.RELEASE_DATA_COLUMN)));
        bundle.putString("overview", cursor.getString
                (cursor.getColumnIndex(MovieContract.MovieEntry.OVERVIEW_COLUMN)));
        bundle.putString("thumb", cursor.getString
                (cursor.getColumnIndex(MovieContract.MovieEntry.THUMBNAIL_COLUMN)));
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
