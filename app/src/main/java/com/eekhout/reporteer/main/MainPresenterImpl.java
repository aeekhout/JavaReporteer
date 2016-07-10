package com.eekhout.reporteer.main;

import android.location.Location;

import com.eekhout.reporteer.libs.base.EventBus;
import com.eekhout.reporteer.main.events.MainEvent;
import com.eekhout.reporteer.main.ui.MainView;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Alexander on 28-06-2016.
 */
public class MainPresenterImpl implements MainPresenter{
    MainView view;
    EventBus eventBus;
    UploadInteractor uploadInteractor;
    SessionInteractor sessionInteractor;

    public MainPresenterImpl(MainView view, EventBus eventBus, UploadInteractor uploadInteractor, SessionInteractor sessionInteractor) {
        this.view = view;
        this.eventBus = eventBus;
        this.uploadInteractor = uploadInteractor;
        this.sessionInteractor = sessionInteractor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        view = null;
        eventBus.unregister(this);
    }

    @Override
    public void uploadPhoto(Location location, String path, String descripcion) {
        uploadInteractor.execute(location, path, descripcion);
    }

    @Override
    @Subscribe
    public void onEventMainThread(MainEvent event) {
        String error = event.getError();
        if (this.view != null) {
            switch (event.getType()) {
                case MainEvent.UPLOAD_INIT:
                    view.onUploadInit();
                    break;
                case MainEvent.UPLOAD_COMPLETE:
                    view.onUploadComplete();
                    break;
                case MainEvent.UPLOAD_ERROR:
                    view.onUploadError(error);
                    break;
            }
        }
    }

    @Override
    public void logout() {
        sessionInteractor.logout();
    }
}
