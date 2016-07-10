package com.eekhout.reporteer.login.di;

import com.eekhout.reporteer.PhotoFeedAppModule;
import com.eekhout.reporteer.domain.di.DomainModule;
import com.eekhout.reporteer.libs.di.LibsModule;
import com.eekhout.reporteer.login.ui.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Alexander on 27-06-2016.
 */
@Singleton
@Component(modules = {LoginModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface LoginComponent {
    void inject(LoginActivity activity);
}