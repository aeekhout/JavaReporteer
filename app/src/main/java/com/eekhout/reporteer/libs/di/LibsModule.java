package com.eekhout.reporteer.libs.di;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.eekhout.reporteer.libs.CloudinaryImageStorage;
import com.eekhout.reporteer.libs.GlideImageLoader;
import com.eekhout.reporteer.libs.base.EventBus;
import com.eekhout.reporteer.libs.base.ImageLoader;
import com.eekhout.reporteer.libs.base.ImageStorage;
import com.eekhout.reporteer.libs.GreenRobotEventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexander on 27-06-2016.
 */
@Module
public class LibsModule {
    private Fragment fragment;

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @Singleton
    EventBus providesEventBus() {
        return new GreenRobotEventBus();
    }

    @Provides
    @Singleton
    ImageLoader providesImageLoader(Fragment fragment) {
        GlideImageLoader imageLoader = new GlideImageLoader();
        if (fragment != null) {
            imageLoader.setLoaderContext(fragment);
        }
        return imageLoader;
    }

    @Provides
    @Singleton
    ImageStorage providesImageStorage(Context context, EventBus eventBus) {
        ImageStorage imageStorage = new CloudinaryImageStorage(context, eventBus);
        return imageStorage;
    }

    @Provides
    @Singleton
    Fragment providesFragment(){
        return this.fragment;
    }
}

