package com.eekhout.reporteer.libs.di;

import com.eekhout.reporteer.PhotoFeedAppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Alexander on 27-06-2016.
 */
@Singleton
@Component(modules = {LibsModule.class, PhotoFeedAppModule.class})
public interface LibsComponent {
}
