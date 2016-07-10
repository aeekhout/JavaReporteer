package com.eekhout.reporteer.photomap.di;

import com.eekhout.reporteer.domain.FirebaseAPI;
import com.eekhout.reporteer.libs.base.EventBus;
import com.eekhout.reporteer.photomap.PhotoMapInteractor;
import com.eekhout.reporteer.photomap.PhotoMapInteractorImpl;
import com.eekhout.reporteer.photomap.PhotoMapPresenter;
import com.eekhout.reporteer.photomap.PhotoMapPresenterImpl;
import com.eekhout.reporteer.photomap.PhotoMapRepository;
import com.eekhout.reporteer.photomap.PhotoMapRepositoryImpl;
import com.eekhout.reporteer.photomap.ui.PhotoMapView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexander on 28-06-2016.
 */
@Module
public class PhotoMapModule {
    PhotoMapView view;

    public PhotoMapModule(PhotoMapView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    PhotoMapView providesPhotoContentView() {
        return this.view;
    }

    @Provides @Singleton
    PhotoMapPresenter providesPhotoContentPresenter(EventBus eventBus, PhotoMapView view, PhotoMapInteractor listInteractor) {
        return new PhotoMapPresenterImpl(eventBus, view, listInteractor);
    }

    @Provides @Singleton
    PhotoMapInteractor providesPhotoContentInteractor(PhotoMapRepository repository) {
        return new PhotoMapInteractorImpl(repository);
    }

    @Provides @Singleton
    PhotoMapRepository providesPhotoContentRepository(FirebaseAPI firebase, EventBus eventBus) {
        return new PhotoMapRepositoryImpl(firebase, eventBus);
    }
}

