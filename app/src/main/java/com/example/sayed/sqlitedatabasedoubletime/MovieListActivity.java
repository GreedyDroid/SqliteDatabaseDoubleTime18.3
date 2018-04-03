package com.example.sayed.sqlitedatabasedoubletime;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MovieListActivity extends AppCompatActivity {

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

        movieListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String movieName = movies.get(position).getMovieName();
                String movieYear = movies.get(position).getMovieYear();
                int rowId = movies.get(position).getMovieID();
                int movieImg = movies.get(position).getMovieImg();

                startActivity(new Intent(MovieListActivity.this, MovieDetail.class)
                    .putExtra("name", movieName)
                    .putExtra("year", movieYear)
                    .putExtra("rowId", rowId)
                    .putExtra("image", movieImg));
            }
        });

        movieListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                final int rowId =  movies.get(position).getMovieID();

                AlertDialog.Builder  alert = new AlertDialog.Builder(MovieListActivity.this);
                alert.setTitle(movies.get(position).getMovieName())
                        .setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(MovieListActivity.this, MainActivity.class)
                                    .putExtra("name", movies.get(position).getMovieName())
                                    .putExtra("id", movies.get(position).getMovieID())
                                    .putExtra("year", movies.get(position).getMovieYear()));
                            }
                        }).setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog.Builder alertDelete = new AlertDialog.Builder(MovieListActivity.this);
                        alertDelete.setTitle("Delete Item!")
                                .setMessage("Are you sure to delete this Item?")
                                .setPositiveButton("sure", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        boolean status = movieDatabaseSource.deleteMovie(rowId);
                                        if (status){
                                            startActivity(new Intent(MovieListActivity.this, MovieListActivity.class));
                                        }else {
                                            Toast.makeText(MovieListActivity.this, "Failed, Try Again", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                })
                                .setNegativeButton("Cancel", null);
                        alertDelete.show();
                    }
                });
                alert.show();

                return true;
            }
        });
    }
}
