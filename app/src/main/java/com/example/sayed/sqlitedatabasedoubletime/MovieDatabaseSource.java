package com.example.sayed.sqlitedatabasedoubletime;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class MovieDatabaseSource {
    private MovieDatabaseHelper movieDatabaseHelper;
    private SQLiteDatabase sqLiteDatabase;

    public MovieDatabaseSource(Context context) {
        movieDatabaseHelper = new MovieDatabaseHelper(context);
    }
    public void open(){
        sqLiteDatabase = movieDatabaseHelper.getWritableDatabase();
    }
    public void close(){
        sqLiteDatabase.close();
    }
    public boolean addMovie(Movie movie){
        this.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(movieDatabaseHelper.COL_NAME, movie.getMovieName());
        contentValues.put(movieDatabaseHelper.COL_YEAR, movie.getMovieYear());
        long row_ID = sqLiteDatabase.insert(movieDatabaseHelper.TABLE_NAME, null, contentValues);
        this.close();

        if (row_ID>0){
            return true;
        }else {
            return false;
        }
    }

    public ArrayList<Movie> getAllMovies() {
        ArrayList<Movie>movies = new ArrayList<>();
        this.open();
        /*Cursor cursor = sqLiteDatabase.rawQuery("select * form "+movieDatabaseHelper
                                .TABLE_NAME, null);*/
        Cursor cursor = sqLiteDatabase.query(movieDatabaseHelper.TABLE_NAME,
                    null, null, null,null,null,null);

        if (cursor.moveToFirst()){
            do {
                int id = cursor.getInt(cursor.getColumnIndex(MovieDatabaseHelper.COL_ID));
                String movieName = cursor.getString(cursor.getColumnIndex(MovieDatabaseHelper.COL_NAME));
                String movieYear = cursor.getString(cursor.getColumnIndex(MovieDatabaseHelper.COL_YEAR));
                Movie movie = new Movie(id, movieName,movieYear, R.mipmap.ic_launcher_round );
                movies.add(movie);
            }while (cursor.moveToNext());
        }
        cursor.close();
        this.close();

        return movies;
    }
}
