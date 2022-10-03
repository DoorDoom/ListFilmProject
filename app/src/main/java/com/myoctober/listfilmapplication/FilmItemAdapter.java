package com.myoctober.listfilmapplication;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class FilmItemAdapter extends RecyclerView.Adapter<FilmViewHolder> {
    private LayoutInflater inflater;
    private List<FilmItem> items;

    public FilmItemAdapter(LayoutInflater inflater, List<FilmItem> items) {
        this.inflater = inflater;
        this.items = items;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new FilmViewHolder(inflater.inflate(R.layout.item_film, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int i) {
        holder.bind(items.get(i));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
