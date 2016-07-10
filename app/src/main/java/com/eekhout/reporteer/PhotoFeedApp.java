package com.eekhout.reporteer;

import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.eekhout.reporteer.domain.di.DomainModule;
import com.eekhout.reporteer.libs.di.LibsModule;
import com.eekhout.reporteer.login.di.DaggerLoginComponent;
import com.eekhout.reporteer.login.di.LoginComponent;
import com.eekhout.reporteer.login.di.LoginModule;
import com.eekhout.reporteer.login.ui.LoginView;
import com.eekhout.reporteer.main.di.DaggerMainComponent;
import com.eekhout.reporteer.main.di.MainComponent;
import com.eekhout.reporteer.main.di.MainModule;
import com.eekhout.reporteer.main.ui.MainView;
import com.eekhout.reporteer.photolist.di.DaggerPhotoListComponent;
import com.eekhout.reporteer.photolist.di.PhotoListComponent;
import com.eekhout.reporteer.photolist.di.PhotoListModule;
import com.eekhout.reporteer.photolist.ui.PhotoListView;
import com.eekhout.reporteer.photolist.ui.adapters.OnItemClickListener;
import com.eekhout.reporteer.photomap.di.DaggerPhotoMapComponent;
import com.eekhout.reporteer.photomap.di.PhotoMapComponent;
import com.eekhout.reporteer.photomap.di.PhotoMapModule;
import com.eekhout.reporteer.photomap.ui.PhotoMapView;
import com.firebase.client.Firebase;

/**
 * Created by Alexander on 27-06-2016.
 */
public class PhotoFeedApp extends Application {
    private final static String EMAIL_KEY = "email";
    private LibsModule libsModule;
    private DomainModule domainModule;
    private PhotoFeedAppModule photoFeedAppModule;

    @Override
    public void onCreate() {
        super.onCreate();
        initFirebase();
        initModules();
    }

    private void initModules() {
        libsModule = new LibsModule();
        domainModule = new DomainModule();
        photoFeedAppModule = new PhotoFeedAppModule(this);
    }

    private void initFirebase() {
        Firebase.setAndroidContext(this);
    }

    public static String getEmailKey() {
        return EMAIL_KEY;
    }

    public PhotoListComponent getPhotoListComponent(Fragment fragment, PhotoListView view, OnItemClickListener onItemClickListener) {
        libsModule.setFragment(fragment);

        return DaggerPhotoListComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(libsModule)
                .photoListModule(new PhotoListModule(view, onItemClickListener))
                .build();

    }

    public PhotoMapComponent getPhotoMapComponent(Fragment fragment, PhotoMapView view) {
        libsModule.setFragment(fragment);

        return DaggerPhotoMapComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(libsModule)
                .photoMapModule(new PhotoMapModule(view))
                .build();

    }

    public MainComponent getMainComponent(MainView view, FragmentManager manager, Fragment[]fragments, String[] titles) {
        return DaggerMainComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(libsModule)
                .mainModule(new MainModule(view, manager, fragments, titles))
                .build();
    }

    public LoginComponent getLoginComponent(LoginView view) {
        return DaggerLoginComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(libsModule)
                .loginModule(new LoginModule(view))
                .build();

    }

    private final static String ABOUT_URL = "https://about.me/adriancatalan";

    public String getAboutUrl(){
        return ABOUT_URL;
    }
}
