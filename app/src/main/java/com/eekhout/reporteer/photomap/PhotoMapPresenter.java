package com.eekhout.reporteer.photomap;

import com.eekhout.reporteer.photomap.events.PhotoMapEvent;

/**
 * Created by Alexander on 28-06-2016.
 */
public interface PhotoMapPresenter {
    void onCreate();
    void onDestroy();

    void subscribe();
    void unsubscribe();

    void onEventMainThread(PhotoMapEvent event);

}
