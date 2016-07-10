package com.eekhout.reporteer.photolist.di;

import com.eekhout.reporteer.PhotoFeedAppModule;
import com.eekhout.reporteer.photolist.ui.PhotoListFragment;
import com.eekhout.reporteer.domain.di.DomainModule;
import com.eekhout.reporteer.libs.di.LibsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Alexander on 28-06-2016.
 */
@Singleton
@Component(modules = {PhotoListModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface PhotoListComponent {
    void inject(PhotoListFragment fragment);
}
