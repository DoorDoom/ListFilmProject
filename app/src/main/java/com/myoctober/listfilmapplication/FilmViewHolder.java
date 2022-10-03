package com.myoctober.listfilmapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FilmViewHolder extends RecyclerView.ViewHolder{
    private TextView titleFilm;
    private TextView subtitileFilm;

    public FilmViewHolder(@NonNull View itemView) {
        super(itemView);

        titleFilm = itemView.findViewById(R.id.title);
        subtitileFilm = itemView.findViewById(R.id.subtitle);
    }

    public void bind(FilmItem item){
        titleFilm.setText(item.title);
        subtitileFilm.setText(item.subtitle);
    }
}
