package com.codepath.flicks;

import java.util.ArrayList;

/**
 * Created by sharonyu on 2017/2/18.
 */
public class MovieGson {
    public int page;
    public ArrayList<Results> results = new ArrayList<>();

    public class Results {
        public String poster_path;
        public String overview;
        public String title;
        public String backdrop_path;
        public float vote_average;
        public String release_date;
        public String id;

        public String getId() {
            return id;
        }

        public String getDate() {
            return release_date;
        }

        public float getVote() {
            return vote_average;
        }

        public String getGuide() {
            return overview;
        }

        public String getTitle() {
            return title;
        }

        public String getBackPath(){
            return backdrop_path;
        }

        public String getPostPath(){
            return poster_path;
        }



    }
}
