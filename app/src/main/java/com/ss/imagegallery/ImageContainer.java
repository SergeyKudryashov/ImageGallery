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
        mImageList.add(Uri.parse("https://pp.userapi.com/c543101/v543101323/31764/HMPdEdqo-vo.jpg"));
        mImageList.add(Uri.parse("https://pp.userapi.com/c637324/v637324159/464d7/6snIF_VcW5w.jpg"));
        mImageList.add(Uri.parse("https://pp.userapi.com/c837321/v837321634/5250a/oJ52lelezjU.jpg"));
        mImageList.add(Uri.parse("https://pp.userapi.com/c543101/v543101633/1f534/2N8_bkZ5I_k.jpg"));
        mImageList.add(Uri.parse("https://pp.userapi.com/c637120/v637120165/4a11b/wXJkANyetDg.jpg"));
        mImageList.add(Uri.parse("https://pp.userapi.com/c543101/v543101715/2412d/Jqdiw6LCoPc.jpg"));
        mImageList.add(Uri.parse("https://pp.userapi.com/c543104/v543104715/55d12/XtlB6V7PqTM.jpg"));
        mImageList.add(Uri.parse("https://pp.userapi.com/c637527/v637527283/37f84/LkpyFVYmDrU.jpg"));
    }
}
