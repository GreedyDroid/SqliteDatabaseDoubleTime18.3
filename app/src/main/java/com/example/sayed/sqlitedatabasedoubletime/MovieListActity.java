package com.example.sayed.sqlitedatabasedoubletime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MovieListActity extends AppCompatActivity {

    private ListView movieListView;
    private MovieAdapter movieAdapter;
    private ArrayList<Movie>movies;
    private MovieDatabaseSource movieDatabaseSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list_actity);

        movieListView = findViewById(R.id.movieListViewID);
        movieDatabaseSource = new MovieDatabaseSource(this);
        movies = movieDatabaseSource.getAllMovies();

        movieAdapter = new MovieAdapter(this, movies);
        movieListView.setAdapter(movieAdapter);
    }
}
