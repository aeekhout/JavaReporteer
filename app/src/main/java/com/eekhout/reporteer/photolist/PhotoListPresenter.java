package com.eekhout.reporteer.photolist;

import com.eekhout.reporteer.entities.Photo;
import com.eekhout.reporteer.photolist.events.PhotoListEvent;

/**
 * Created by Alexander on 28-06-2016.
 */
public interface PhotoListPresenter {
    void onCreate();
    void onDestroy();

    void subscribe();
    void unsubscribe();

    void removePhoto(Photo photo);
    void onEventMainThread(PhotoListEvent event);
}
