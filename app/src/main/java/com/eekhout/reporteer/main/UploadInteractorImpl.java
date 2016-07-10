package com.eekhout.reporteer.main;

import android.location.Location;

/**
 * Created by Alexander on 28-06-2016.
 */
public class UploadInteractorImpl  implements UploadInteractor {
    private MainRepository repository;

    public UploadInteractorImpl(MainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Location location, String path, String descripcion) {
        repository.uploadPhoto(location, path, descripcion);
    }

}
