package com.udacity.moviesapp.model;

import java.util.List;

/**
 * Created by The Dev Wolf on 08-03-2018.
 */

public class MovieReview {


    /**
     * id : 500
     * page : 1
     * results : [{"id":"573776f8c3a36805ab001040","author":"talisencrw","content":"This unique take on the heist-film-gone-wrong was excellent--stylish and intelligently made, yet very funny and inexpensive. Tarantino's accolades from giving American cinema the resuscitation it needed mirrors what has happened, at least since the 70's, with Martin Scorsese's 'Mean Streets', both in terms of entertaining violence and usage of music in the scoring of films. I greatly thank Harvey Keitel for taking a chance on Tarantino back then--It paid off in spades.","url":"https://www.themoviedb.org/review/573776f8c3a36805ab001040"}]
     * total_pages : 1
     * total_results : 1
     */

    private int id;
    private int page;
    private int total_pages;
    private int total_results;
    private List<MovieReviews> results;


    public MovieReview(int id, int page, int total_pages, int total_results, List<MovieReviews> results) {
        this.id = id;
        this.page = page;
        this.total_pages = total_pages;
        this.total_results = total_results;
        this.results = results;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public List<MovieReviews> getResults() {
        return results;
    }

    public void setResults(List<MovieReviews> results) {
        this.results = results;
    }

    public static class MovieReviews {
        /**
         * id : 573776f8c3a36805ab001040
         * author : talisencrw
         * content : This unique take on the heist-film-gone-wrong was excellent--stylish and intelligently made, yet very funny and inexpensive. Tarantino's accolades from giving American cinema the resuscitation it needed mirrors what has happened, at least since the 70's, with Martin Scorsese's 'Mean Streets', both in terms of entertaining violence and usage of music in the scoring of films. I greatly thank Harvey Keitel for taking a chance on Tarantino back then--It paid off in spades.
         * url : https://www.themoviedb.org/review/573776f8c3a36805ab001040
         */

        private String id;
        private String author;
        private String content;
        private String url;


        public MovieReviews(String id, String author, String content, String url) {
            this.id = id;
            this.author = author;
            this.content = content;
            this.url = url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
