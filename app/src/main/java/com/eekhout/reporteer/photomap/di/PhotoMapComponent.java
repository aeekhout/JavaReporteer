package com.eekhout.reporteer.photomap.di;

import com.eekhout.reporteer.PhotoFeedAppModule;
import com.eekhout.reporteer.photomap.ui.PhotoMapFragment;
import com.eekhout.reporteer.domain.di.DomainModule;
import com.eekhout.reporteer.libs.di.LibsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Alexander on 28-06-2016.
 */
@Singleton
@Component(modules = {PhotoMapModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface PhotoMapComponent {
    void inject(PhotoMapFragment fragment);
}

