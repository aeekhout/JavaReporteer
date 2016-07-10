package com.eekhout.reporteer.libs.base;

import java.io.File;

/**
 * Created by Alexander on 27-06-2016.
 */
public interface ImageStorage {
    String getImageUrl(String id);
    void upload(File file, String id, ImageStorageFinishedListener listener);
}
