package com.udacity.moviesapp.data;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by The Dev Wolf on 07-03-2018.
 */

public final class MovieContract {
    public static final String CONTENT_AUTHORITY = "moviesapp.data.MovieProvider";
    public static final String PATH_PETS = "movie";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);


    public static final class MovieEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PETS);


        public static final String TABLE_NAME = "favourite";
        public static final String _id = "id";
        public static final String TITLE_COLUMN = "title";
        public static final String OVERVIEW_COLUMN = "overview";
        public static final String RELEASE_DATA_COLUMN = "releaseData";
        public static final String RATING_COLUMN = "rate";
        public static final String THUMBNAIL_COLUMN = "thumbnail";
        public static final String POSTER_COLUMN = "poster";

    }
}
