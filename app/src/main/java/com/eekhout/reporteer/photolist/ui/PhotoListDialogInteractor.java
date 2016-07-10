package com.eekhout.reporteer.photolist.ui;

import android.support.v4.app.DialogFragment;

/**
 * Created by Alexander on 09-07-2016.
 */
public interface PhotoListDialogInteractor {
    void onDialogPositiveClick(DialogFragment dialog, String descripcion);
    void onDialogNegativeClick(DialogFragment dialog, String descripcion);
}
