package com.myoctober.listfilmapplication;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myoctober.listfilmapplication.databinding.ItemFilmBinding;

import java.util.List;
import java.util.zip.Inflater;

public class FilmItemAdapter extends RecyclerView.Adapter {

    private static final int VIEW_TYPE_HEADER =0;
    private static final int VIEW_TYPE_ITEM =1;
    private static final int VIEW_TYPE_FOOTER =2;

    private LayoutInflater inflater;
    private List<FilmItem> items;

    public FilmItemAdapter(LayoutInflater inflater, List<FilmItem> items) {
        this.inflater = inflater;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_HEADER)
            return new SimpleTextHeaderViewHolder(inflater.inflate(R.layout.header_text, parent, false));
        else
            return new FilmViewHolder(ItemFilmBinding.inflate(inflater,parent, false).getRoot());
    }

    @Override
    public int getItemViewType(int position) {
        return position==0 ? VIEW_TYPE_HEADER :VIEW_TYPE_ITEM;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof FilmViewHolder)
            ((FilmViewHolder)holder).bind(items.get(position-1));
    }

    @Override
    public int getItemCount() {
        return items.size() + 1;
    } // +1 за хеадером
}
