package com.eekhout.reporteer.photolist;

import com.eekhout.reporteer.domain.FirebaseAPI;
import com.eekhout.reporteer.domain.FirebaseActionListenerCallback;
import com.eekhout.reporteer.domain.FirebaseEventListenerCallback;
import com.eekhout.reporteer.entities.Photo;
import com.eekhout.reporteer.libs.base.EventBus;
import com.eekhout.reporteer.photolist.events.PhotoListEvent;
import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by Alexander on 28-06-2016.
 */
public class PhotoListRepositoryImpl implements PhotoListRepository {
    private EventBus eventBus;
    private FirebaseAPI firebase;
 //   private

    public PhotoListRepositoryImpl(FirebaseAPI firebase, EventBus eventBus) {
        this.firebase = firebase;
        this.eventBus = eventBus;
    }

    @Override
    public void subscribe() {

        firebase.checkForData(new FirebaseActionListenerCallback() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onError(FirebaseError error) {
                if (error != null) {
                    post(PhotoListEvent.READ_EVENT, error.getMessage());
                } else {
                    post(PhotoListEvent.READ_EVENT, "");
                }

            }
        });
        firebase.subscribe(new FirebaseEventListenerCallback() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot) {
                Photo photo = dataSnapshot.getValue(Photo.class);
                photo.setId(dataSnapshot.getKey());

                String email = firebase.getAuthEmail();

                boolean publishedByMy = photo.getEmail().equals(email);
                photo.setPublishedByMe(publishedByMy);
                post(PhotoListEvent.READ_EVENT, photo);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Photo photo = dataSnapshot.getValue(Photo.class);
                photo.setId(dataSnapshot.getKey());

                post(PhotoListEvent.DELETE_EVENT, photo);
            }

            @Override
            public void onCancelled(FirebaseError error) {
                post(PhotoListEvent.READ_EVENT, error.getMessage());
            }
        });
    }

    @Override
    public void unsubscribe() {
        firebase.unsubscribe();
    }

    @Override
    public void remove(final Photo photo) {
        firebase.remove(photo, new FirebaseActionListenerCallback() {
            @Override
            public void onSuccess() {
                post(PhotoListEvent.DELETE_EVENT, photo);
            }

            @Override
            public void onError(FirebaseError error) {

            }
        });
    }

    private void post(int type, Photo photo){
        post(type, photo, null);
    }

    private void post(int type, String error){
        post(type, null, error);
    }

    private void post(int type, Photo photo, String error){
        PhotoListEvent event = new PhotoListEvent();
        event.setType(type);
        event.setError(error);
        event.setPhoto(photo);
        eventBus.post(event);
    }
}
