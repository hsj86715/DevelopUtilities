package cn.com.farmcode.utility.widgets.cirlescale;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import cn.com.farmcode.utility.widgets.CircleScaleView;
import cn.com.farmcode.utility.widgets.R;

/**
 * @author hushujun
 */
abstract class AbstractDelegate implements CircleScaleDelegate {
    private DelegateImpl mDelegateImpl;
    protected Context mContext;
    protected CircleScaleView mCircleScaleView;
    protected int mScaleMode = ScaleMode.UNDEFINED;
    protected int mIndicatorColor = Color.argb(204, 255, 255, 255);
    protected int mScaleTextColor = Color.WHITE;
    protected int mScaleThinColor = Color.argb(128, 255, 255, 255);
    protected int mScaleThickColor = Color.WHITE;
    protected int mCircleBorderColor = Color.TRANSPARENT;
    protected int mRadarScanColor = Color.TRANSPARENT;
    protected int mScaleStepCount = 100;

    protected float mIndicatorStroke;
    protected float mScaleTextSize;
    protected float mCurrentAngle;
    protected float mScaleThinStroke;
    protected float mScaleThickStroke;
    protected float mCircleBorderStroke;

    protected boolean showCircleBorder = false;

    public AbstractDelegate(CircleScaleView circleScaleView, Context context, @Nullable AttributeSet attributeSet) {
        mCircleScaleView = circleScaleView;
        mContext = context;
        initAttribute(context, attributeSet);
    }

    private void initAttribute(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CircleScaleView);
            setScaleMode(ta.getInt(R.styleable.CircleScaleView_scale_mode, ScaleMode.UNDEFINED));
            setHalfDirection(ta.getInt(R.styleable.CircleScaleView_half_direction, HalfDirection.UNDEFINED));
            setIndicatorColor(ta.getColor(R.styleable.CircleScaleView_indicator_color, mIndicatorColor));
            setIndicatorStroke(ta.getDimensionPixelSize(R.styleable.CircleScaleView_indicator_stroke, 0));
            setScaleTextColor(ta.getColor(R.styleable.CircleScaleView_scale_value_textColor, Color.WHITE));
            setScaleTextSize(ta.getDimensionPixelSize(R.styleable.CircleScaleView_scale_value_textSize, 0));
            setScaleStepsCount(ta.getInt(R.styleable.CircleScaleView_scale_step_count, mScaleStepCount));
            setScaleThickColor(ta.getColor(R.styleable.CircleScaleView_scale_color_thick, mScaleThickColor));
            setScaleThinColor(ta.getColor(R.styleable.CircleScaleView_scale_color_thin, mScaleThinColor));
            setScaleThickStroke(ta.getDimensionPixelSize(R.styleable.CircleScaleView_scale_thick_stroke, 0));
            setScaleThinStroke(ta.getDimensionPixelSize(R.styleable.CircleScaleView_scale_thin_stroke, 0));
            setRadarScanColor(ta.getColor(R.styleable.CircleScaleView_radar_scan_color, Color.TRANSPARENT));
            showCircleBorder(ta.getBoolean(R.styleable.CircleScaleView_show_circle_border, false));
            setCircleBorderColor(ta.getColor(R.styleable.CircleScaleView_circle_border_color, Color.TRANSPARENT));
            setCircleBorderStroke(ta.getDimensionPixelSize(R.styleable.CircleScaleView_circle_border_stroke, 0));
            int from = ta.getInt(R.styleable.CircleScaleView_fan_degree_from, 0);
            int to = ta.getInt(R.styleable.CircleScaleView_fan_degree_to, 180);
            setFanDegree(from, to);

            ta.recycle();
        }
    }

    public void setDelegateImpl(DelegateImpl impl) {
        if (impl != null) {
            mDelegateImpl = impl;
            mDelegateImpl.setDelegate(this);
            mDelegateImpl.initPaint();
        }
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public CircleScaleView getCircleScaleView() {
        return mCircleScaleView;
    }

    @Override
    public void setCurrentAngle(float angleDegree) {
        mCurrentAngle = angleDegree;
    }

    @Override
    public float getCurrentAngle() {
        return mCurrentAngle;
    }

    @Override
    public void setIndicatorColor(int color) {
        mIndicatorColor = color;
    }

    @Override
    public int getIndicatorColor() {
        return mIndicatorColor;
    }

    @Override
    public void setIndicatorStroke(float indicatorStroke) {
        mIndicatorStroke = indicatorStroke;
    }

    @Override
    public float getIndicatorStroke() {
        return mIndicatorStroke;
    }

    @Override
    public void setIndicatorColorRes(int colorRes) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setIndicatorColor(mContext.getResources().getColor(colorRes, mContext.getTheme()));
        } else {
            setIndicatorColor(mContext.getResources().getColor(colorRes));
        }
    }

    @Override
    public void setScaleTextColor(int color) {
        mScaleTextColor = color;
    }

    @Override
    public int getScaleTextColor() {
        return mScaleTextColor;
    }

    @Override
    public void setScaleTextColorRes(int colorRes) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setScaleTextColor(mContext.getResources().getColor(colorRes, mContext.getTheme()));
        } else {
            setScaleTextColor(mContext.getResources().getColor(colorRes));
        }
    }

    @Override
    public void setScaleTextSize(float textSize) {
        mScaleTextSize = textSize;
    }

    @Override
    public float getScaleTextSize() {
        return mScaleTextSize;
    }

    @Override
    public void setScaleStepsCount(int count) {
        mScaleStepCount = count;
    }

    @Override
    public int getScaleStepsCount() {
        return mScaleStepCount;
    }

    @Override
    public void setScaleThickColor(int color) {
        mScaleThickColor = color;
    }

    @Override
    public int getScaleThickColor() {
        return mScaleThickColor;
    }

    @Override
    public void setScaleThickColorRes(int colorRes) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setScaleThickColor(mContext.getResources().getColor(colorRes, mContext.getTheme()));
        } else {
            setScaleThickColor(mContext.getResources().getColor(colorRes));
        }
    }

    @Override
    public void setScaleThickStroke(float thickStroke) {
        mScaleThickStroke = thickStroke;
    }

    @Override
    public float getScaleThickStroke() {
        return mScaleThickStroke;
    }

    @Override
    public void setScaleThinColor(int color) {
        mScaleThinColor = color;
    }

    @Override
    public int getScaleThinColor() {
        return mScaleThinColor;
    }

    @Override
    public void setScaleThinColorRes(int colorRes) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setScaleThinColor(mContext.getResources().getColor(colorRes, mContext.getTheme()));
        } else {
            setScaleThinColor(mContext.getResources().getColor(colorRes));
        }
    }

    @Override
    public void setScaleThinStroke(float thinStroke) {
        mScaleThinStroke = thinStroke;
    }

    @Override
    public float getScaleThinStroke() {
        return mScaleThinStroke;
    }

    @Override
    public void setRadarScanColor(int color) {
        if (mScaleMode == ScaleMode.RADAR) {
            mRadarScanColor = color;
        }
    }

    @Override
    public int getRadarScanColor() {
        return mRadarScanColor;
    }

    @Override
    public void setRadarScanColorRes(int colorRes) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setRadarScanColor(mContext.getResources().getColor(colorRes, mContext.getTheme()));
        } else {
            setRadarScanColor(mContext.getResources().getColor(colorRes));
        }
    }

    @Override
    public void showCircleBorder(boolean show) {
        showCircleBorder = show;
    }

    @Override
    public boolean isShowCircleBorder() {
        return showCircleBorder;
    }

    @Override
    public void setCircleBorderStroke(float borderStroke) {
        mCircleBorderStroke = borderStroke;
    }

    @Override
    public float getCircleBorderStroke() {
        return mCircleBorderStroke;
    }

    @Override
    public void setCircleBorderColor(int color) {
        mCircleBorderColor = color;
    }

    @Override
    public int getCircleBorderColor() {
        return mCircleBorderColor;
    }

    @Override
    public void setCircleBorderColorRes(int colorRes) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setCircleBorderColor(mContext.getResources().getColor(colorRes, mContext.getTheme()));
        } else {
            setCircleBorderColor(mContext.getResources().getColor(colorRes));
        }
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mDelegateImpl != null) {
            mDelegateImpl.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        if (mDelegateImpl != null) {
            mDelegateImpl.draw(canvas);
        }
    }

    @Override
    public void onAttachedToWindow() {
        if (mDelegateImpl != null) {
            mDelegateImpl.onAttachedToWindow();
        }

    }

    @Override
    public void onDetachedFromWindow() {
        if (mDelegateImpl != null) {
            mDelegateImpl.onDetachedFromWindow();
        }
    }

    @Override
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (mDelegateImpl != null) {
            mDelegateImpl.onSizeChanged(w, h, oldw, oldh);
        }
    }
}
