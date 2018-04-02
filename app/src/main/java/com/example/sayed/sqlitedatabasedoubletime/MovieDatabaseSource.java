package com.example.sayed.sqlitedatabasedoubletime;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
}
