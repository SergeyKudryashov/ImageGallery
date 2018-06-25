package com.ss.imagegallery;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ss.imagegallery.adapter.ImageGalleryAdapter;
import com.ss.imagegallery.fragment.ImageGalleryFragment;

public class MainActivity extends AppCompatActivity {
    private final String SAVED_INSTANCE_STATE_KEY = "fragmentInstanceSaved";

    private ImageGalleryFragment mImageGalleryFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (savedInstanceState == null) {
            mImageGalleryFragment = new ImageGalleryFragment();
            fragmentTransaction.add(R.id.fragment_container, mImageGalleryFragment).commit();
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, SAVED_INSTANCE_STATE_KEY,
                getSupportFragmentManager().findFragmentById(R.id.fragment_container));
    }
}
