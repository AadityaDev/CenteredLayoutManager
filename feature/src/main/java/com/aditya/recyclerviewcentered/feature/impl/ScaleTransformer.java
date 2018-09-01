package com.aditya.recyclerviewcentered.feature.impl;

import android.view.View;

import com.aditya.recyclerviewcentered.feature.view.CenterLayoutManager;

public class ScaleTransformer implements CenterLayoutManager.ItemTransformer {

    private static final String TAG = "CurveTransformer";


    @Override
    public void transformItem(CenterLayoutManager layoutManager, View item, float fraction) {
        item.setPivotX(item.getWidth() / 2.f);
        item.setPivotY(item.getHeight()/2.0f);
        float scale = 1 - 0.2f * Math.abs(fraction);
        item.setScaleX(scale);
        item.setScaleY(scale);
    }
}
