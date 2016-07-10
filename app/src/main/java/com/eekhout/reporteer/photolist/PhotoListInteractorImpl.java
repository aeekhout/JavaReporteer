package com.eekhout.reporteer.photolist;

import com.eekhout.reporteer.entities.Photo;

/**
 * Created by Alexander on 28-06-2016.
 */
public class PhotoListInteractorImpl  implements PhotoListInteractor {

    PhotoListRepository repository;

    public PhotoListInteractorImpl(PhotoListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void subscribe() {
        repository.subscribe();
    }

    @Override
    public void unsubscribe() {
        repository.unsubscribe();
    }

    @Override
    public void removePhoto(Photo photo) {
        repository.remove(photo);
    }
}
