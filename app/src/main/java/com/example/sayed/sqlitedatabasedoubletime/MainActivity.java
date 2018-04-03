package com.example.sayed.sqlitedatabasedoubletime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText movieNameET, movieYearET;
    private MovieDatabaseSource movieDatabaseSource;
    private Movie movie;
    private Button submintBT;
    private String movieNameEd, movieYearEd;
    private int rowID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        movieNameET = findViewById(R.id.movieNameETid);
        movieYearET = findViewById(R.id.movieYearETid);
        movieDatabaseSource = new MovieDatabaseSource(this);
        
        //For Edit
        submintBT = findViewById(R.id.submitBT);
        submintBT.setText("Submit");
        rowID =  getIntent().getIntExtra("id",0);
        if (rowID>0){
            submintBT.setText("Edit");
            movieNameEd = getIntent().getStringExtra("name");
            movieYearEd = getIntent().getStringExtra("year");
            movieNameET.setText(movieNameEd);
            movieYearET.setText(movieYearEd);
        }
    }

    public void submitBT(View view) {
        String name = movieNameET.getText().toString();
        String year = movieYearET.getText().toString();
        if (name.isEmpty()){
            movieNameET.setError("Enter Movie Name");
        }else if(year.isEmpty()){
            movieYearET.setText("Enter Year");
        }else {
            if (rowID>0){
                movie = new Movie(rowID, name, year, R.mipmap.ic_launcher_round);
                boolean status = movieDatabaseSource.updateMovie(movie, rowID);
                if (status){
                    startActivity(new Intent(MainActivity.this, MovieListActivity.class));
                }else{
                    Toast.makeText(this, "Faild to Update", Toast.LENGTH_SHORT).show();
                }
            }else {
                movie = new Movie(name, year);
                boolean status = movieDatabaseSource.addMovie(movie);
                if (status){
                    startActivity(new Intent(MainActivity.this, MovieListActivity.class));
                }else {
                    Toast.makeText(this, "Could Not Connect", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public void goToMovieList(View view) {
        startActivity(new Intent(this, MovieListActivity.class));
    }
}
