package com.ss.imagegallery.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ss.imagegallery.ImageContainer;
import com.ss.imagegallery.R;
import com.ss.imagegallery.adapter.ImageGalleryAdapter;

public class ImageGalleryFragment extends Fragment {
    private final int DOTS_COUNT = 5;
    private final float RATIO_SCALE = 0.3f;

    private Context mContext;
    private ViewPager mViewPager;
    private LinearLayout mDotsLayout;

    private TextView[] mDots;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image_gallery, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mViewPager = view.findViewById(R.id.view_page_main);
        mDotsLayout = view.findViewById(R.id.dots_layout);


        mViewPager.setAdapter(new ImageGalleryAdapter(getContext()));
        mViewPager.setOffscreenPageLimit(ImageContainer.getInstance().size());

        float density = getResources().getDisplayMetrics().density;
        int partialWidth = (int) (48 * density); // 16dp
        int pageMargin = (int) (16 * density);

        mViewPager.setClipToPadding(false);
        mViewPager.setPageMargin(pageMargin);
        mViewPager.setPadding(partialWidth, 0, partialWidth, 0);

        if (savedInstanceState != null) {
            mViewPager.setCurrentItem(savedInstanceState.getInt("position"));
        }
        addDotsIndicator(0);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                float scale = 1 - (positionOffset * RATIO_SCALE);
                mViewPager.getChildAt(position).setScaleY(scale);


                if (position + 1 < mViewPager.getAdapter().getCount()) {
                    scale = positionOffset * RATIO_SCALE + (1 - RATIO_SCALE);
                    mViewPager.getChildAt(position + 1).setScaleY(scale);
                }
            }

            @Override
            public void onPageSelected(int position) {
                if (position < DOTS_COUNT / 2) {
                    addDotsIndicator(position);
                } else if (position > ImageContainer.getInstance().size() - DOTS_COUNT / 2 - 1) {
                    addDotsIndicator(DOTS_COUNT - (ImageContainer.getInstance().size() - position));
                } else {
                    addDotsIndicator(DOTS_COUNT / 2);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                mViewPager.getChildAt(mViewPager.getCurrentItem()).setScaleY(1);

                if (mViewPager.getCurrentItem() > 0) {
                    mViewPager.getChildAt(mViewPager.getCurrentItem() - 1 ).setScaleY(1 - RATIO_SCALE);
                }

                if (mViewPager.getCurrentItem() + 1 < mViewPager.getAdapter().getCount()) {
                    mViewPager.getChildAt(mViewPager.getCurrentItem() + 1 ).setScaleY(1 - RATIO_SCALE);
                }
            }
        });
    }

    public void addDotsIndicator(int position) {

        mDots = new TextView[DOTS_COUNT];
        mDotsLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(getContext());
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotsLayout.addView(mDots[i]);
        }

        if (mDots.length != 0)
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("position", mViewPager.getCurrentItem());
    }
}
