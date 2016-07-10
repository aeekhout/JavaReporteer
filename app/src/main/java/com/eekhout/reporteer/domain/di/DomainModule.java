package com.eekhout.reporteer.domain.di;

import android.content.Context;
import android.location.Geocoder;

import com.eekhout.reporteer.domain.FirebaseAPI;
import com.eekhout.reporteer.domain.Util;
import com.firebase.client.Firebase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexander on 27-06-2016.
 */
@Module
public class DomainModule {
    private final static String FIREBASE_URL = "https://eekhoutphotos.firebaseio.com/";

    @Provides
    @Singleton
    FirebaseAPI providesFirebaseAPI(Firebase firebase) {
        return new FirebaseAPI(firebase);
    }

    @Provides
    @Singleton
    Firebase providesFirebase() {
        return new Firebase(FIREBASE_URL);
    }

    @Provides
    @Singleton
    Util providesUtil(Geocoder geocoder) {
        return new Util(geocoder);
    }

    @Provides
    @Singleton
    Geocoder providesGeocoder(Context context) {
        return new Geocoder(context);
    }
}

