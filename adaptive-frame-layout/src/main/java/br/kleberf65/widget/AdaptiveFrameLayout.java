package br.kleberf65.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import br.kleberf65.utils.Params;
import br.kleberf65.utils.ViewParams;

public class AdaptiveFrameLayout extends FrameLayout {

    private int screenDivider = 2, heightPercentage = 45,
            incrementWidth = 0;
    private boolean isMatchParent = false;
    private Context context;

    public AdaptiveFrameLayout(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public AdaptiveFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AdaptiveFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public AdaptiveFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(changeParams(layoutParams));
    }

    public void setScreenDivider(int screenDivider) {
        this.screenDivider = screenDivider;
    }

    public void setMatchParent(boolean matchParent) {
        isMatchParent = matchParent;
    }

    public void setHeightPercentage(int heightPercentage) {
        this.heightPercentage = heightPercentage;
    }

    public void setIncrementWidth(int incrementWidth) {
        this.incrementWidth = incrementWidth;
    }

    public void start() {
        setLayoutParams(getLayoutParams());
    }

    private void init(Context context, AttributeSet attrs) {
        this.context = context;
        if (attrs != null) {
            try {

                TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AdaptiveFrameLayout);
                screenDivider = a.getInt(R.styleable.AdaptiveFrameLayout_afl_screenDivider,
                        2);
                heightPercentage = a.getInt(R.styleable.AdaptiveFrameLayout_afl_heightPercentage,
                        45);
                incrementWidth = a.getInt(R.styleable.AdaptiveFrameLayout_afl_incrementWidth,
                        0);
                isMatchParent = a.getBoolean(R.styleable.AdaptiveFrameLayout_afl_isMatchParent,
                        false);
                
                a.recycle();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private ViewParams findViewParams() {
        return new ViewParams(context, screenDivider, heightPercentage, incrementWidth);
    }

    private ViewGroup.LayoutParams changeParams(ViewGroup.LayoutParams layoutParams) {
        Params params = findViewParams().get();
        layoutParams.width = isMatchParent ?
                ViewGroup.LayoutParams.MATCH_PARENT : params.getWidth();
        layoutParams.height = params.getHeight();
        return layoutParams;
    }
}
