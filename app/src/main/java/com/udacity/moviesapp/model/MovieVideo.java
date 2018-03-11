package com.udacity.moviesapp.model;

import java.util.List;

/**
 * Created by The Dev Wolf on 08-03-2018.
 */

public class MovieVideo {


    /**
     * id : 500
     * results : [{"id":"55c21c439251410f19004d0c","iso_639_1":"en","iso_3166_1":"US","key":"GLPJSmUHZvU","name":"Trailer 1","site":"YouTube","size":360,"type":"Trailer"},{"id":"58b33867c3a368528d00a775","iso_639_1":"en","iso_3166_1":"US","key":"GyR4RK0LA_E","name":"Opening scene","site":"YouTube","size":720,"type":"Clip"}]
     */

    private int id;
    private List<MovieVideos> results;

    public MovieVideo(int id, List<MovieVideos> results) {
        this.id = id;
        this.results = results;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MovieVideos> getResults() {
        return results;
    }

    public void setResults(List<MovieVideos> results) {
        this.results = results;
    }

    public static class MovieVideos {
        /**
         * id : 55c21c439251410f19004d0c
         * iso_639_1 : en
         * iso_3166_1 : US
         * key : GLPJSmUHZvU
         * name : Trailer 1
         * site : YouTube
         * size : 360
         * type : Trailer
         */

        private String id;
        private String iso_639_1;
        private String iso_3166_1;
        private String key;
        private String name;
        private String site;
        private int size;
        private String type;

        public MovieVideos(String id, String iso_639_1, String iso_3166_1, String key, String name, String site, int size, String type) {
            this.id = id;
            this.iso_639_1 = iso_639_1;
            this.iso_3166_1 = iso_3166_1;
            this.key = key;
            this.name = name;
            this.site = site;
            this.size = size;
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIso_639_1() {
            return iso_639_1;
        }

        public void setIso_639_1(String iso_639_1) {
            this.iso_639_1 = iso_639_1;
        }

        public String getIso_3166_1() {
            return iso_3166_1;
        }

        public void setIso_3166_1(String iso_3166_1) {
            this.iso_3166_1 = iso_3166_1;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
