package com.eekhout.reporteer.photolist;

import com.eekhout.reporteer.entities.Photo;

/**
 * Created by Alexander on 28-06-2016.
 */
public interface PhotoListRepository {
    void subscribe();
    void unsubscribe();
    void remove(Photo photo);
}
