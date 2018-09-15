package com.kamalqawlaq.criminalintent;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class CrimePictureFragment extends DialogFragment {

    private static final String ARG_PHOTO = "photo";

    private ImageView pictureImageView;
    private Bitmap imageBitmap;
    private String imagePath;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imagePath = getArguments().getString(ARG_PHOTO);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_crime_picture, null);
        pictureImageView = v.findViewById(R.id.crime_image);
        imageBitmap = PictureUtils.getScaledBitmap(imagePath, getActivity());

        if(imageBitmap != null){
            pictureImageView.setImageBitmap(imageBitmap);
        } else {
            pictureImageView.setImageDrawable(null);
        }
        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setPositiveButton("OK", null)
                .create();

    }

    public static CrimePictureFragment newInstance(String path){
        Bundle args = new Bundle();
        args.putString(ARG_PHOTO, path);

        CrimePictureFragment fragment = new CrimePictureFragment();
        fragment.setArguments(args);

        return fragment;
    }
}
