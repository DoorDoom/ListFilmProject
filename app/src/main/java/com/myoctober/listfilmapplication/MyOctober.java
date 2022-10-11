package com.myoctober.listfilmapplication;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyOctober extends Application {
    public final static String SETTINGS = "Setting";
    public final static String LIST_FILMS = "listFilm";
    public final static String TAG_APP = "AppInfo";


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public void onCreate() {
        try {
            initListFilm();
        }catch (JSONException e) {
            e.printStackTrace();
        }
        super.onCreate();
    }

    private void initListFilm() throws JSONException{

        sharedPreferences = getSharedPreferences(SETTINGS,MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if(sharedPreferences.contains(LIST_FILMS)){
            Log.i(TAG_APP, "Список уже существует");
        }else {
            JSONArray filmArray = new JSONArray();

            Resources resources = getResources();

            for (int i = 1; i < 6; i++) {
                try {
                    JSONObject film = new JSONObject();
                    switch (i) {
                        case 1:
                            film.put("title", resources.getString(R.string.jojo1_title));
                            film.put("subtitle", resources.getString(R.string.jojo1_text));
                            film.put("picture", getResources().getIdentifier("jojo1", "drawable", getPackageName()));
                            break;
                        case 2:
                            film.put("title", resources.getString(R.string.jojo2_title));
                            film.put("subtitle", resources.getString(R.string.jojo2_text));
                            film.put("picture", getResources().getIdentifier("jojo2", "drawable", getPackageName()));
                            break;
                        case 3:
                            film.put("title",resources.getString( R.string.jojo3_title));
                            film.put("subtitle", resources.getString(R.string.jojo3_text));
                            film.put("picture", getResources().getIdentifier("jojo3", "drawable", getPackageName()));
                            break;
                        case 4:
                            film.put("title", resources.getString(R.string.jojo4_title));
                            film.put("subtitle", resources.getString(R.string.jojo4_text));
                            film.put("picture", getResources().getIdentifier("jojo4", "drawable", getPackageName()));
                            break;
                        case 5:
                            film.put("title", resources.getString(R.string.jojo5_title));
                            film.put("subtitle", resources.getString(R.string.jojo5_text));
                            film.put("picture", getResources().getIdentifier("jojo5", "drawable", getPackageName()));
                            break;
                    }
                    Log.i(TAG_APP, "Создан элемент фильма: " + film.toString());
                    filmArray.put(film);
                } catch (JSONException e) {
                    Log.i(TAG_APP, "Ошибка при создании элемента фильма: " + i);
                    e.printStackTrace();
                }
            }

            editor.putString(LIST_FILMS, filmArray.toString());
            editor.commit();

            Log.i(TAG_APP, filmArray.toString());
        }
    }
}
