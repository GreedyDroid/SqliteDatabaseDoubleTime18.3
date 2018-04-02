package com.example.sayed.sqlitedatabasedoubletime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText movieNameET, movieYearET;
    private MovieDatabaseSource movieDatabaseSource;
    private Movie movie;
  // private String movieNameEd, movieYearEd;
    private int rowID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        movieNameET = findViewById(R.id.movieNameETid);
        movieYearET = findViewById(R.id.movieYearETid);
        movieDatabaseSource = new MovieDatabaseSource(this);
        
        
    }

    public void submitBT(View view) {
        String name = movieNameET.getText().toString();
        String year = movieYearET.getText().toString();
        if (name.isEmpty()){
            movieNameET.setError("Enter Movie Name");
        }else if(year.isEmpty()){
            movieYearET.setText("Enter Year");
        }else {
            movie = new Movie(name, year);
            boolean status = movieDatabaseSource.addMovie(movie);
            if (status){
                startActivity(new Intent(MainActivity.this, MovieListActity.class));
            }else {
                Toast.makeText(this, "Could Not Connect", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
