package com.eekhout.reporteer.main;

/**
 * Created by Alexander on 28-06-2016.
 */
public class SessionInteractorImpl implements SessionInteractor{
    MainRepository repository;

    public SessionInteractorImpl(MainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void logout() {
        repository.logout();
    }
}
