package com.eekhout.reporteer.domain;

import com.firebase.client.FirebaseError;

/**
 * Created by Alexander on 27-06-2016.
 */
public interface FirebaseActionListenerCallback {
    void onSuccess();
    void onError(FirebaseError error);
}
