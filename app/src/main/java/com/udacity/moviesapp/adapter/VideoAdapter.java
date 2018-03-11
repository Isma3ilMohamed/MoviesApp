package com.udacity.moviesapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.udacity.moviesapp.API.Constants;
import com.udacity.moviesapp.API.MovieAPI;
import com.udacity.moviesapp.R;
import com.udacity.moviesapp.model.MovieVideo;

import java.util.List;

/**
 * Created by The Dev Wolf on 09-03-2018.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    //use context to can set pic by picasso
    private Context mContext;

    //use this list as a data source
    private List<MovieVideo.MovieVideos> videos;
    //use this callback to handle click on videos
    private MovieVideoOnClickListener mCallback;


    public VideoAdapter(Context mContext, List<MovieVideo.MovieVideos> videos, MovieVideoOnClickListener mCallback) {
        this.mContext = mContext;
        this.videos = videos;
        this.mCallback = mCallback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        MovieVideo.MovieVideos video = videos.get(position);

        //create youtube image to load it by picasso
        final String url = Constants.YOUTUBE_THUMBNAIL + video.getKey() + Constants.YOUTUBE_THUMBNAIL_SIZE;

        Picasso.with(mContext)
                .load(url)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(holder.iv_video_thumbnail, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {
                        Picasso.with(mContext)
                                .load(url)
                                .placeholder(R.drawable.placeholder)
                                .error(R.drawable.error)
                                .into(holder.iv_video_thumbnail);
                    }
                });

    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView iv_video_thumbnail;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            iv_video_thumbnail = itemView.findViewById(R.id.iv_video_thumbnail);
        }

        @Override
        public void onClick(View view) {
            mCallback.onVideoClick(videos.get(getAdapterPosition()));
        }
    }


    public interface MovieVideoOnClickListener {
        void onVideoClick(MovieVideo.MovieVideos movieVideos);
    }
}
