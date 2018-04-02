package com.example.sayed.sqlitedatabasedoubletime;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends ArrayAdapter<Movie>{

    Context context;
    ArrayList<Movie>movies;

    public MovieAdapter(@NonNull Context context, ArrayList<Movie> movies) {
        super(context,R.layout.row_for_movie_adapter, movies);
        this.context = context;
        this.movies = movies;
    }
    public class MovieViewHolder{
        public TextView movieName, movieYear;
        public ImageView movieImg;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater  = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        MovieViewHolder holder;
        if (convertView == null){
            holder = new MovieViewHolder();
            convertView = inflater.inflate(R.layout.row_for_movie_adapter, parent, false);
            holder.movieImg = convertView.findViewById(R.id.movieImgID);
            holder.movieName = convertView.findViewById(R.id.movieNameID);
            holder.movieYear = convertView.findViewById(R.id.movieYearID);

            convertView.setTag(holder);
        }else {
            holder= (MovieViewHolder) convertView.getTag();
        }

        holder.movieName.setText(movies.get(position).getMovieName());
        holder.movieYear.setText(movies.get(position).getMovieYear());
        holder.movieImg.setImageResource(movies.get(position).getMovieImg());

        return convertView;
    }
}
