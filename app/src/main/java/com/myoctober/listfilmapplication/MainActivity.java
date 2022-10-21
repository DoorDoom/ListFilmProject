package com.myoctober.listfilmapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.myoctober.listfilmapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final String TAG = "myLogs";
    private List<FilmItem> items = new ArrayList<>();
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        items.addAll(FilmsRepository.getInstance(this).getItems());

        RecyclerView recyclerView = binding.recycleView;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new FilmItemAdapter(LayoutInflater.from(this), items));

        binding.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.remove(2);
                recyclerView.getAdapter().notifyItemRemoved(3);
            }
        });

        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add(2, new FilmItem("Добавленный фильм",
                        "Его подзаголовок", getResources().getIdentifier("ic_baseline_image_24", "drawable", getPackageName())));
                recyclerView.getAdapter().notifyItemInserted(3);
            }
        });
    }
}