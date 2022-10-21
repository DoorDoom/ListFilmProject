package com.myoctober.listfilmapplication;

import android.widget.ImageView;

public class BindingAdapters {
    @androidx.databinding.BindingAdapter("android:src")
    public static void setPicture(ImageView view, int idPicture) {
        view.setImageResource(idPicture);
    }
}
