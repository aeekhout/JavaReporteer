package com.eekhout.reporteer.domain.di;

import com.eekhout.reporteer.PhotoFeedAppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Alexander on 27-06-2016.
 */
@Singleton
@Component(modules = {DomainModule.class, PhotoFeedAppModule.class})
public interface DomainComponent {
}