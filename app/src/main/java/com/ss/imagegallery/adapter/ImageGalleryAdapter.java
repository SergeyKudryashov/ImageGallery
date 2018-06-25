package com.ss.imagegallery.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.ss.imagegallery.ImageContainer;

public class ImageGalleryAdapter extends PagerAdapter {
    private final float RATIO_SCALE = 0.3f;

    private LayoutInflater mInflater;
    private Context mContext;

    public ImageGalleryAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        Picasso.get()
                .load(ImageContainer.getInstance().getImage(position))
                .into(imageView);
        imageView.setScaleY(1 - RATIO_SCALE);

        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return ImageContainer.getInstance().getImageList().size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}