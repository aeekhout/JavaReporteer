package com.eekhout.reporteer.main.di;

import com.eekhout.reporteer.PhotoFeedAppModule;
import com.eekhout.reporteer.domain.di.DomainModule;
import com.eekhout.reporteer.libs.di.LibsModule;
import com.eekhout.reporteer.main.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Alexander on 28-06-2016.
 */
@Singleton
@Component(modules = {MainModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface MainComponent {
    void inject(MainActivity activity);
}
