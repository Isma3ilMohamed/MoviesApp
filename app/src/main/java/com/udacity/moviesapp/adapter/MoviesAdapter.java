package com.udacity.moviesapp.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.udacity.moviesapp.API.Constants;
import com.udacity.moviesapp.API.MovieAPI;
import com.udacity.moviesapp.R;
import com.udacity.moviesapp.data.MovieContract;
import com.udacity.moviesapp.model.Movie;

import java.util.List;

/**
 * Created by The Dev Wolf on 07-03-2018.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    //context variable to can set image by picasso
    private Context mContext;
    //this list used as a data source
    private List<Movie.MovieDetail> movies;

    //callback to handle view click
    private MovieOnClickListener mCallback;
    //Add cursor to fetch data from DB
    private Cursor mCursor;


    /*
    * use two constructor
    * first use when fetch data from api
    * second use when fetch data from db
    * */

    public MoviesAdapter(Context mContext, List<Movie.MovieDetail> movies, MovieOnClickListener mCallback) {
        this.mContext = mContext;
        this.movies = movies;
        this.mCallback = mCallback;
    }

    public MoviesAdapter(Context mContext, MovieOnClickListener mCallback, Cursor mCursor) {
        this.mContext = mContext;
        this.mCallback = mCallback;
        this.mCursor = mCursor;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        /*
        * use condition before list or cursor call equal null
        * */

        if (movies != null) {
            Movie.MovieDetail movie = movies.get(position);
            Picasso.with(mContext)
                    .load(Constants.BASE_POSTER_URL + movie.getPoster_path())
                    .error(R.drawable.error)
                    .placeholder(R.drawable.placeholder)
                    .into(holder.iv_poster);
        } else if (mCursor != null) {
            mCursor.moveToPosition(position);
            Picasso.with(mContext)
                    .load(Constants.BASE_POSTER_URL + mCursor.getString
                            (mCursor.getColumnIndex(MovieContract.MovieEntry.POSTER_COLUMN)))
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.error)
                    .networkPolicy(NetworkPolicy.OFFLINE)
                    .into(holder.iv_poster, new Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError() {
                            //try online of offline cache failed
                            Picasso.with(mContext)
                                    .load(Constants.BASE_POSTER_URL + mCursor.getString
                                            (mCursor.getColumnIndex(MovieContract.MovieEntry.POSTER_COLUMN)))
                                    .placeholder(R.drawable.placeholder)
                                    .error(R.drawable.error)
                                    .into(holder.iv_poster);
                        }
                    });

        }
    }

    @Override
    public int getItemCount() {
        if (movies != null) {
            return movies.size();
        } else if (mCursor != null) {
            return mCursor.getCount();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView iv_poster;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            iv_poster = itemView.findViewById(R.id.iv_poster);
        }


        @Override
        public void onClick(View view) {

            if (movies != null) {

                mCallback.onMovieClick(movies.get(getAdapterPosition()));
            } else {

                mCallback.onFavouriteMovieClick(mCursor, getAdapterPosition());
            }


        }
    }

    public interface MovieOnClickListener {
        void onMovieClick(Movie.MovieDetail movieDetail);

        void onFavouriteMovieClick(Cursor cursor, int Position);

    }


}
