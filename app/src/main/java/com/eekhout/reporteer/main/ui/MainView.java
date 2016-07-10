package com.eekhout.reporteer.main.ui;

/**
 * Created by Alexander on 28-06-2016.
 */
public interface MainView {
    void onUploadInit();
    void onUploadComplete();
    void onUploadError(String error);
}
