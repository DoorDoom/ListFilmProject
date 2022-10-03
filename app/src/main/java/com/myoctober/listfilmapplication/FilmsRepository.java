package com.myoctober.listfilmapplication;

import java.util.ArrayList;
import java.util.List;

public class FilmsRepository {
    private static List<FilmItem> items = new ArrayList<>();
    private static FilmsRepository instance;

    private FilmsRepository() {
        for (int i = 0; i<30; i++){
            items.add(new FilmItem("Заголовок"+ i,"Подголовок"+ i,"",0));
        }
    }

    public static FilmsRepository getInstance() {
        if (instance == null)
            instance = new FilmsRepository();
        return instance;
    }

    public static List<FilmItem> getItems() {
        return items;
    }
}
