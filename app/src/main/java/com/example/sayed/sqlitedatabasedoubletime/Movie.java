package com.example.sayed.sqlitedatabasedoubletime;

public class Movie {
    private String movieName;
    private String movieYear;
    private int movieID;
    private  int movieImg;

    public Movie(String movieName, String movieYear, int movieID, int movieImg) {
        this.movieName = movieName;
        this.movieYear = movieYear;
        this.movieID = movieID;
        this.movieImg = movieImg;
    }

    public Movie(String movieName, String movieYear) {
        this.movieName = movieName;
        this.movieYear = movieYear;
    }

    public Movie() {
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public int getMovieImg() {
        return movieImg;
    }

    public void setMovieImg(int movieImg) {
        this.movieImg = movieImg;
    }
}
