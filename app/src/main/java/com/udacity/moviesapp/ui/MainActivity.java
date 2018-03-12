package com.udacity.moviesapp.ui;

import android.os.Handler;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.udacity.moviesapp.API.MovieAPI;
import com.udacity.moviesapp.API.RetrofitCall;
import com.udacity.moviesapp.BuildConfig;
import com.udacity.moviesapp.R;
import com.udacity.moviesapp.adapter.MoviesAdapter;
import com.udacity.moviesapp.data.MovieContract;
import com.udacity.moviesapp.databinding.ActivityMainBinding;
import com.udacity.moviesapp.model.Movie;
import com.udacity.moviesapp.utils.ConnectionUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MoviesAdapter.MovieOnClickListener {

    //DataBinding declare
    private ActivityMainBinding mMainBinding;
    //to switch between states (Top Rated | Most Popular)
    private static int currentState = 1;
    //declare movie adapter
    private MoviesAdapter adapter;
    //declare movie details list to retrieve data inside it
    private List<Movie.MovieDetail> details;
    //string var as key for movie detail object
    private static final String MOVIE_KEY = "key";

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
        mMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        setSupportActionBar(mMainBinding.toolbarMain);
        if (getSupportActionBar() != null) {

            getSupportActionBar().setTitle(this.getString(R.string.app_name));
        }

        layoutManager = new GridLayoutManager(this, 2);
        mMainBinding.rvMovies.setLayoutManager(layoutManager);

        if (ConnectionUtils.checkConnection(this)) {
            retrieveMovies(currentState);
        } else {
            Snackbar snackbar = Snackbar.make(mMainBinding.relative, getString(R.string.not_connected), Snackbar.LENGTH_SHORT);
            snackbar.show();
            startActivity(new Intent(MainActivity.this, FavouriteActivity.class));
        }
    }


    //To clear list before add new items
    private void clean() {
        if (details != null) {
            details.clear();
        }
    }

    //retrieve movies depend on it's state
    private void retrieveMovies(int state) {
        if (state == 0) {
            currentState = 0;
            getSupportActionBar().setTitle("Most Popular Movies");
            clean();
            MovieAPI movieAPI = RetrofitCall.getMovie().create(MovieAPI.class);

            Call<Movie> movieCall = movieAPI.getPopularMovie(BuildConfig.API_KEY);

            movieCall.enqueue(new Callback<Movie>() {
                @Override
                public void onResponse(Call<Movie> call, Response<Movie> response) {
                    details = response.body().getResults();
                    adapter = new MoviesAdapter(MainActivity.this, details, MainActivity.this);
                    adapter.notifyDataSetChanged();
                    mMainBinding.rvMovies.setAdapter(adapter);

                    //Toast.makeText(getApplicationContext(),details.get(5).getTitle(),Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(Call<Movie> call, Throwable t) {

                }
            });
        } else if (state == 1) {

            currentState = 1;
            getSupportActionBar().setTitle("Top Rated Movies");
            clean();

            MovieAPI movieAPI = RetrofitCall.getMovie().create(MovieAPI.class);

            Call<Movie> movieCall = movieAPI.getTopRatedMovie(BuildConfig.API_KEY);

            movieCall.enqueue(new Callback<Movie>() {
                @Override
                public void onResponse(Call<Movie> call, Response<Movie> response) {
                    details = response.body().getResults();
                    adapter = new MoviesAdapter(MainActivity.this, details, MainActivity.this);
                    adapter.notifyDataSetChanged();
                    mMainBinding.rvMovies.setAdapter(adapter);

                    //Toast.makeText(getApplicationContext(),details.get(5).getTitle(),Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(Call<Movie> call, Throwable t) {

                }
            });
        }

    }

    //to retrieve favourite movies from cursor



    //handle movie on click
    @Override
    public void onMovieClick(Movie.MovieDetail movieDetail) {

        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(MOVIE_KEY, movieDetail);
        startActivity(intent);

    }

    //handle favourite on click
    @Override
    public void onFavouriteMovieClick(Cursor cursor, int Position) {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.sort_action) {
            final CharSequence sort[] = new CharSequence[]{"Top Rated", "Most Popular", "Favourite"};

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Select Sort Type ");
            builder.setItems(sort, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (sort[which] == sort[0]) {
                        if (currentState != 1) {
                            retrieveMovies(1);
                        }
                    } else if (sort[which] == sort[1]) {
                        if (currentState != 0) {
                            retrieveMovies(0);
                        }
                    } else if (sort[which] == sort[2]) {
                        startActivity(new Intent(MainActivity.this, FavouriteActivity.class));
                    }
                }
            });

            builder.show();
        }
        return super.onOptionsItemSelected(item);
    }


    //store recycler view state to retrieve it after rotation
    @Override
    protected void onPause() {
        super.onPause();
        mBundleRecyclerViewState = new Bundle();
        recyclerViewStateParcelable = mMainBinding.rvMovies.getLayoutManager().onSaveInstanceState();
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
                    mMainBinding.rvMovies.getLayoutManager().onRestoreInstanceState(recyclerViewStateParcelable);

                }
            }, 50);
        }

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

            layoutManager.setSpanCount(2);

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {

            layoutManager.setSpanCount(2);

        }
        mMainBinding.rvMovies.setLayoutManager(layoutManager);
    }


}
