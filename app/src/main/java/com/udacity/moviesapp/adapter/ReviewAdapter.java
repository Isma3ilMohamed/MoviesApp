package com.udacity.moviesapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.udacity.moviesapp.R;
import com.udacity.moviesapp.model.MovieReview;

import java.util.List;

/**
 * Created by The Dev Wolf on 09-03-2018.
 */

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

    //use this list as a data source
    private List<MovieReview.MovieReviews> reviews;

    public ReviewAdapter(List<MovieReview.MovieReviews> reviews) {

        this.reviews = reviews;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MovieReview.MovieReviews review = reviews.get(position);

        holder.tv_auther.setText(review.getAuthor());
        holder.tv_content.setText(review.getContent());
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_auther;
        TextView tv_content;


        public ViewHolder(View itemView) {
            super(itemView);
            tv_auther = itemView.findViewById(R.id.tv_auther);
            tv_content = itemView.findViewById(R.id.tv_content);
        }
    }
}
