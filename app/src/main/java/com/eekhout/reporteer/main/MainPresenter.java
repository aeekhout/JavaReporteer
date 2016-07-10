package com.eekhout.reporteer.main;

import android.location.Location;

import com.eekhout.reporteer.main.events.MainEvent;

/**
 * Created by Alexander on 28-06-2016.
 */
public interface MainPresenter {
    void onCreate();
    void onDestroy();

    void logout();
    void uploadPhoto(Location location, String path, String descripcion);
    void onEventMainThread(MainEvent event);
}
