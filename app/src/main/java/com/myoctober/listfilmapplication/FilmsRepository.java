package com.myoctober.listfilmapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FilmsRepository {
    public final static String SETTINGS = "Setting";
    public final static String LIST_FILMS = "listFilm";
    public final static String TAG_REPOSITORY = "RepositInfo";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private static List<FilmItem> items = new ArrayList<>();
    private static FilmsRepository instance;


    private FilmsRepository(Context context) {

        sharedPreferences = context.getSharedPreferences(SETTINGS, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String array="";
        try {
            if (sharedPreferences.contains(LIST_FILMS)) {
                array = (sharedPreferences.getString(LIST_FILMS, null));
                JSONArray jsonArray = new JSONArray(array);
                Log.i(TAG_REPOSITORY, jsonArray.toString());
                for (int i = 0; i<jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    items.add(new FilmItem(jsonObject.getString("title"), jsonObject.getString("subtitle"), jsonObject.getString("picture")));
                }
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static FilmsRepository getInstance(Context context) {
        if (instance == null)
            instance = new FilmsRepository(context);
        return instance;
    }

    public static List<FilmItem> getItems() {
        return items;
    }
}
