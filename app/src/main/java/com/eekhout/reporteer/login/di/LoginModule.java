package com.eekhout.reporteer.login.di;

import com.eekhout.reporteer.domain.FirebaseAPI;
import com.eekhout.reporteer.libs.base.EventBus;
import com.eekhout.reporteer.login.LoginInteractor;
import com.eekhout.reporteer.login.LoginInteractorImpl;
import com.eekhout.reporteer.login.LoginPresenter;
import com.eekhout.reporteer.login.LoginPresenterImpl;
import com.eekhout.reporteer.login.LoginRepository;
import com.eekhout.reporteer.login.LoginRepositoryImpl;
import com.eekhout.reporteer.login.SignupInteractor;
import com.eekhout.reporteer.login.SignupInteractorImpl;
import com.eekhout.reporteer.login.ui.LoginView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexander on 27-06-2016.
 */
@Module
public class LoginModule {
    LoginView view;

    public LoginModule(LoginView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    LoginView providesLoginView() {
        return this.view;
    }

    @Provides @Singleton
    LoginPresenter providesLoginPresenter(EventBus eventBus, LoginView loginView, LoginInteractor loginInteractor, SignupInteractor signupInteractor) {
        return new LoginPresenterImpl(eventBus, loginView, loginInteractor, signupInteractor);
    }

    @Provides @Singleton
    LoginInteractor providesLoginInteractor(LoginRepository repository) {
        return new LoginInteractorImpl(repository);
    }

    @Provides @Singleton
    SignupInteractor providesSignupInteractor(LoginRepository repository) {
        return new SignupInteractorImpl(repository);
    }

    @Provides @Singleton
    LoginRepository providesLoginRepository(FirebaseAPI firebase, EventBus eventBus) {
        return new LoginRepositoryImpl(firebase, eventBus);
    }
}
