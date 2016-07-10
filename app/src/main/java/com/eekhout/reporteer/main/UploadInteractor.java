package com.eekhout.reporteer.main;

import android.location.Location;

/**
 * Created by Alexander on 28-06-2016.
 */
public interface UploadInteractor {
    void execute(Location location, String path, String descripcion);
}
