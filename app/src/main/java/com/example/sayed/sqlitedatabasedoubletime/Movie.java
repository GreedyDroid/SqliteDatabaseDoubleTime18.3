package com.example.sayed.sqlitedatabasedoubletime;

public class Movie {
    private int movieID;
    private String movieName;
    private String movieYear;
    private  int movieImg;

    public Movie(int movieID, String movieName, String movieYear, int movieImg) {
        this.movieID = movieID;
        this.movieName = movieName;
        this.movieYear = movieYear;
        this.movieImg = movieImg;
    }

    public Movie(String movieName, String movieYear) {
        this.movieName = movieName;
        this.movieYear = movieYear;
    }

    public Movie(int id, String movieName, String name, String movieYear, int ic_launcher_round) {
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
