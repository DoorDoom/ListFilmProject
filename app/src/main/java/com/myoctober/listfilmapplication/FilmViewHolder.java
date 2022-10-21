package com.myoctober.listfilmapplication;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.myoctober.listfilmapplication.databinding.ItemFilmBinding;

public class FilmViewHolder extends RecyclerView.ViewHolder{
    private ItemFilmBinding binding;

    public FilmViewHolder(@NonNull View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }

    public void bind(FilmItem item){

        binding.setFilmItem(item);
    }
}
