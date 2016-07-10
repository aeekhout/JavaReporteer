package com.eekhout.reporteer.photolist.di;

import com.eekhout.reporteer.photolist.ui.adapters.OnItemClickListener;
import com.eekhout.reporteer.photolist.ui.adapters.PhotoListAdapter;
import com.eekhout.reporteer.photolist.ui.PhotoListView;
import com.eekhout.reporteer.domain.FirebaseAPI;
import com.eekhout.reporteer.domain.Util;
import com.eekhout.reporteer.entities.Photo;
import com.eekhout.reporteer.libs.base.EventBus;
import com.eekhout.reporteer.libs.base.ImageLoader;
import com.eekhout.reporteer.photolist.PhotoListInteractor;
import com.eekhout.reporteer.photolist.PhotoListInteractorImpl;
import com.eekhout.reporteer.photolist.PhotoListPresenter;
import com.eekhout.reporteer.photolist.PhotoListPresenterImpl;
import com.eekhout.reporteer.photolist.PhotoListRepository;
import com.eekhout.reporteer.photolist.PhotoListRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexander on 28-06-2016.
 */
@Module
public class PhotoListModule {
    PhotoListView view;
    OnItemClickListener onItemClickListener;

    public PhotoListModule(PhotoListView view, OnItemClickListener onItemClickListener) {
        this.view = view;
        this.onItemClickListener = onItemClickListener;
    }

    @Provides @Singleton
    PhotoListView providesPhotoContentView() {
        return this.view;
    }

    @Provides @Singleton
    PhotoListPresenter providesPhotoListPresenter(EventBus eventBus, PhotoListView view, PhotoListInteractor listInteractor) {
        return new PhotoListPresenterImpl(eventBus, view, listInteractor);
    }

    @Provides @Singleton
    PhotoListInteractor providesPhotoListInteractor(PhotoListRepository repository) {
        return new PhotoListInteractorImpl(repository);
    }

    @Provides @Singleton
    PhotoListRepository providesPhotoListRepository(FirebaseAPI firebase, EventBus eventBus) {
        return new PhotoListRepositoryImpl(firebase, eventBus);
    }

    @Provides @Singleton
    PhotoListAdapter providesPhotosAdapter(Util utils, List<Photo> photoList, ImageLoader imageLoader, OnItemClickListener onItemClickListener) {
        return new PhotoListAdapter(utils, photoList, imageLoader, onItemClickListener);
    }

    @Provides @Singleton
    OnItemClickListener providesOnItemClickListener() {
        return this.onItemClickListener;
    }

    @Provides
    @Singleton
    List<Photo> providesPhotosList() {
        return new ArrayList<Photo>();
    }

}
