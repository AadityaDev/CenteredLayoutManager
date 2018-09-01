package com.aditya.recyclerviewcentered.feature.impl;

import android.view.View;

import com.aditya.recyclerviewcentered.feature.view.CenterLayoutManager;

public class CurveTransformer implements CenterLayoutManager.ItemTransformer {
    public static final int ROTATE_ANGEL = 7;
    private static final String TAG = "CurveTransformer";


    @Override
    public void transformItem(CenterLayoutManager layoutManager, View item, float fraction) {
        if (layoutManager.getOrientation() == CenterLayoutManager.VERTICAL) {
            return;
        }
        int width = item.getWidth();
        int height = item.getHeight();
        item.setPivotX(width / 2.f);
        item.setPivotY(height);
        float scale = 1 - 0.1f * Math.abs(fraction);
        item.setScaleX(scale);
        item.setScaleY(scale);
        item.setRotation(ROTATE_ANGEL * fraction);
        item.setTranslationY((float) (Math.sin(2 * Math.PI * ROTATE_ANGEL * Math.abs(fraction) / 360.f) * width / 2.0f));
        item.setTranslationX((float) ((1 - scale) * width / 2.0f / Math.cos(2 * Math.PI * ROTATE_ANGEL * fraction / 360.f)));
        if (fraction > 0) {
            item.setTranslationX(-item.getTranslationX());
        }
        item.setAlpha(1 - 0.2f * Math.abs(fraction));
    }
}
