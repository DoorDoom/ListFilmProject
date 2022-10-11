package com.myoctober.listfilmapplication;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

public class FilmViewHolder extends RecyclerView.ViewHolder{
    private TextView titleFilm;
    private ImageView filmImage;

    public FilmViewHolder(@NonNull View itemView) {
        super(itemView);

        titleFilm = itemView.findViewById(R.id.title);
        filmImage = itemView.findViewById(R.id.imageView);
    }

    public void bind(FilmItem item){

        titleFilm.setText(item.title);
        filmImage.setImageResource(item.picture);
    }
}
