package com.example.sayed.sqlitedatabasedoubletime;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MovieDatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "Movie Database";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "tbl_movie";
    public static final String COL_ID = "tbl_id";
    public static final String COL_NAME = "tbl_name";
    public static final String COL_YEAR = "tbl_year";

    public static final String CREATE_TABLE_MOVIE= "create table "+TABLE_NAME+"("+COL_ID+
            " integer primary key autoincrement, "+COL_NAME+" text, "+COL_YEAR+ " text);";

    public MovieDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MOVIE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
