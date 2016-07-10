package com.eekhout.reporteer.photomap.ui;

import com.eekhout.reporteer.entities.Photo;

/**
 * Created by Alexander on 28-06-2016.
 */
public interface PhotoMapView {
    void addPhoto(Photo photo);
    void removePhoto(Photo photo);
    void onPhotosError(String error);
}
