package com.eekhout.reporteer.photolist.ui.adapters;

import android.widget.ImageView;

import com.eekhout.reporteer.entities.Photo;

/**
 * Created by Alexander on 28-06-2016.
 */
public interface OnItemClickListener {
    void onPlaceClick(Photo photo);
    void onShareClick(Photo photo, ImageView img);
    void onDeleteClick(Photo photo);
}
