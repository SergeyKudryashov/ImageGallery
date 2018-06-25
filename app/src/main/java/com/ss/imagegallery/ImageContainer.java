package com.ss.imagegallery;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class ImageContainer {

    private static List<Uri> mImageList;

    private static ImageContainer mImageContainer;

    public static ImageContainer getInstance() {
        if (mImageContainer == null) {
            mImageContainer = new ImageContainer();
        }
        return mImageContainer;
    }

    private ImageContainer() {
        mImageList = new ArrayList<>();
        fillImages();
    }

    public Uri getImage(int position) {
        return mImageList.get(position);
    }

    public List<Uri> getImageList() {
        return mImageList;
    }

    public int size() {
        return mImageList.size();
    }

    private void fillImages() {
        mImageList.add(Uri.parse("https://pp.userapi.com/c543101/v543101949/45208/Ws86z7hIiXM.jpg"));
        mImageList.add(Uri.parse("https://pp.userapi.com/c543101/v543101949/45208/Ws86z7hIiXM.jpg"));
        mImageList.add(Uri.parse("https://pp.userapi.com/c543101/v543101949/45208/Ws86z7hIiXM.jpg"));
        mImageList.add(Uri.parse("https://pp.userapi.com/c543101/v543101949/45208/Ws86z7hIiXM.jpg"));
        mImageList.add(Uri.parse("https://pp.userapi.com/c543101/v543101949/45208/Ws86z7hIiXM.jpg"));
        mImageList.add(Uri.parse("https://pp.userapi.com/c543101/v543101949/45208/Ws86z7hIiXM.jpg"));
        mImageList.add(Uri.parse("https://pp.userapi.com/c543101/v543101949/45208/Ws86z7hIiXM.jpg"));
        mImageList.add(Uri.parse("https://pp.userapi.com/c543101/v543101949/45208/Ws86z7hIiXM.jpg"));
        mImageList.add(Uri.parse("https://pp.userapi.com/c543101/v543101949/45208/Ws86z7hIiXM.jpg"));
        mImageList.add(Uri.parse("https://pp.userapi.com/c543101/v543101949/45208/Ws86z7hIiXM.jpg"));
    }
}
