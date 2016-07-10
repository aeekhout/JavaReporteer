package com.eekhout.reporteer.photolist.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.eekhout.reporteer.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Alexander on 09-07-2016.
 */
public class PhotoListDialog extends DialogFragment {

    @Bind(R.id.editDescripcion)
    EditText inputDescripcion;

    private PhotoListDialogInteractor listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
           listener = (PhotoListDialogInteractor) activity;
        } catch (ClassCastException e) {
          throw new ClassCastException(activity.toString()
                    + " must implement DialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle(R.string.descripcion_message_title)
                .setPositiveButton(R.string.descripcion_message_add,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                listener.onDialogPositiveClick(PhotoListDialog.this, inputDescripcion.getText().toString());
                            }
                        })
                .setNegativeButton(R.string.descripcion_message_cancel,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                listener.onDialogNegativeClick(PhotoListDialog.this, inputDescripcion.getText().toString());
                            }
                        });

        LayoutInflater i = getActivity().getLayoutInflater();
        View view = i.inflate(R.layout.descripcion_dialog, null);
        ButterKnife.bind(this, view);
        builder.setView(view);

        AlertDialog dialog = builder.create();

        return dialog;
    }
}
