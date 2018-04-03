package com.example.sayed.sqlitedatabasedoubletime;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MovieDetail extends AppCompatActivity {
    private String movieName, movieYear;
    private int movieIMG, rowID;
    private TextView nameTV, yearTV;
    private ImageView movieIV;
    private MovieDatabaseSource movieDatabaseSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        nameTV = findViewById(R.id.movieNameDetailET);
        yearTV = findViewById(R.id.movieYearDetailET);
        movieIV = findViewById(R.id.movieDetailImgID);

        movieDatabaseSource = new MovieDatabaseSource(this);
        movieName = getIntent().getStringExtra("name");
        movieYear = getIntent().getStringExtra("year");
        movieIMG  = getIntent().getIntExtra("image", R.mipmap.ic_launcher_round);
        rowID = getIntent().getIntExtra("rowId",0);

        nameTV.setText(movieName);
        yearTV.setText(movieYear);
        movieIV.setImageResource(movieIMG);
    }

    public void editMovie(View view) {
        startActivity(new Intent(this, MainActivity.class)
            .putExtra("name", movieName)
            .putExtra("year", movieYear)
            .putExtra("id", rowID));
    }

    public void deleteMovie(View view) {
        AlertDialog.Builder aleart = new AlertDialog.Builder(this);
        aleart.setTitle("Delete Item!")
                .setMessage("Are you sure to delete this Item?")
                .setPositiveButton("sure", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        boolean status = movieDatabaseSource.deleteMovie(rowID);
                        if (status){
                            startActivity(new Intent(MovieDetail.this, MovieListActivity.class));
                        }else {
                            Toast.makeText(MovieDetail.this, "Failed, Try Again", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("Cancel", null);
        aleart.show();
    }
}
