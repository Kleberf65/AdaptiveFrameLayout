package br.kleberf65.utils;

import android.content.Context;
import android.util.TypedValue;

public class ViewParams {

    private final Context context;
    private final int screenDivider,
            heightPercentage, incrementWidth;

    public ViewParams(Context context, int screenDivider, int heightPercentage, int incrementWidth) {
        this.context = context;
        this.screenDivider = screenDivider;
        this.heightPercentage = heightPercentage;
        this.incrementWidth = incrementWidth;
    }

    public Params get() {
        if (heightPercentage == 0) {
            throw new IllegalArgumentException("define heightPercentage > 0!");
        }
        if (incrementWidth < 0) {
            throw new IllegalArgumentException("define incrementWidth >= 0!");
        }
        int width = getWidth() / screenDivider;
        if (incrementWidth > 0) width += getDip(incrementWidth);
        int height = width + (width * heightPercentage / 100);

        return new Params(width, height);
    }

    private int getDip(int value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.getResources().getDisplayMetrics());
    }

    private int getWidth() {
        return (int) context.getResources().getDisplayMetrics().widthPixels;
    }
}
