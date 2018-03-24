package cn.com.farmcode.utility.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import cn.com.farmcode.utility.widgets.cirlescale.CircleMode;
import cn.com.farmcode.utility.widgets.cirlescale.CircleScaleDelegate;
import cn.com.farmcode.utility.widgets.cirlescale.FanCircleDelegate;
import cn.com.farmcode.utility.widgets.cirlescale.HalfCircleDelegate;
import cn.com.farmcode.utility.widgets.cirlescale.WholeCircleDelegate;

/**
 * Created by hushujun on 2018/3/21.
 */
public class CircleScaleView extends View {
    private static final String TAG = "CompassView";
    private CircleScaleDelegate mDelegate;

    public CircleScaleView(Context context) {
        this(context, null);
    }

    public CircleScaleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttribute(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CircleScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initAttribute(context, attrs);
    }

    private void initAttribute(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CircleScaleView);
            int circleMode = ta.getInt(R.styleable.CircleScaleView_circle_mode, CircleMode.WHOLE);
            if (circleMode == CircleMode.HALF) {
                mDelegate = new HalfCircleDelegate(this, context, attrs);
            } else if (circleMode == CircleMode.FAN) {
                mDelegate = new FanCircleDelegate(this, context, attrs);
            } else {
                mDelegate = new WholeCircleDelegate(this, context, attrs);
            }
            ta.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mDelegate.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public int getPaddingStart() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return super.getPaddingStart();
        } else {
            return getPaddingLeft();
        }
    }

    @Override
    public int getPaddingEnd() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return super.getPaddingEnd();
        } else {
            return getPaddingRight();
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(new Runnable() {
            @Override
            public void run() {
                mDelegate.setCurrentAngle(mDelegate.getCurrentAngle() + 6);
                invalidate();
                postDelayed(this, 1000);
            }
        }, 1000);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mDelegate.draw(canvas);
    }

    public void setCurrentAngle(float angleDegree) {
        mDelegate.setCurrentAngle(angleDegree);
    }

    public float getCurrentAngle() {
        return mDelegate.getCurrentAngle();
    }

    public void setIndicatorColor(int color) {
        mDelegate.setIndicatorColor(color);
    }

    public int getIndicatorColor() {
        return mDelegate.getIndicatorColor();
    }

    public void setIndicatorStroke(float indicatorStroke) {
        mDelegate.setIndicatorStroke(indicatorStroke);
    }

    public float getIndicatorStroke() {
        return mDelegate.getIndicatorStroke();
    }

    public void setIndicatorColorRes(int colorRes) {
        mDelegate.setIndicatorColorRes(colorRes);
    }

    public void setScaleTextColor(int color) {
        mDelegate.setScaleTextColor(color);
    }

    public int getScaleTextColor() {
        return mDelegate.getScaleTextColor();
    }

    public void setScaleTextColorRes(int colorRes) {
        mDelegate.setScaleTextColorRes(colorRes);
    }

    public void setScaleTextSize(float textSize) {
        mDelegate.setScaleTextSize(textSize);
    }

    public float getScaleTextSize() {
        return mDelegate.getScaleTextSize();
    }

    public void setScaleStepsCount(int count) {
        mDelegate.setScaleStepsCount(count);
    }

    public int getScaleStepsCount() {
        return mDelegate.getScaleStepsCount();
    }

    public void setScaleThickColor(int color) {
        mDelegate.setScaleThickColor(color);
    }

    public int getScaleThickColor() {
        return mDelegate.getScaleThickColor();
    }

    public void setScaleThickColorRes(int colorRes) {
        mDelegate.setScaleThickColorRes(colorRes);
    }

    public void setScaleThickStroke(float thickStroke) {
        mDelegate.setScaleThickStroke(thickStroke);
    }

    public float getScaleThickStroke() {
        return mDelegate.getScaleThickStroke();
    }

    public void setScaleThinColor(int color) {
        mDelegate.setScaleThinColor(color);
    }

    public int getScaleThinColor() {
        return mDelegate.getScaleThinColor();
    }

    public void setScaleThinColorRes(int colorRes) {
        mDelegate.setScaleThinColorRes(colorRes);
    }

    public void setScaleThinStroke(float thinStroke) {
        mDelegate.setScaleThinStroke(thinStroke);
    }

    public float getScaleThinStroke() {
        return mDelegate.getScaleThinStroke();
    }

    public void setRadarScanColor(int color) {
        mDelegate.setRadarScanColor(color);
    }

    public int getRadarScanColor() {
        return mDelegate.getRadarScanColor();
    }

    public void setRadarScanColorRes(int colorRes) {
        mDelegate.setRadarScanColorRes(colorRes);
    }

    public void showCircleBorder(boolean show) {
        mDelegate.showCircleBorder(show);
    }

    public boolean isShowCircleBorder() {
        return mDelegate.isShowCircleBorder();
    }

    public void setCircleBorderStroke(float borderStroke) {
        mDelegate.setCircleBorderStroke(borderStroke);
    }

    public float getCircleBorderStroke() {
        return mDelegate.getCircleBorderStroke();
    }

    public void setCircleBorderColor(int color) {
        mDelegate.setCircleBorderColor(color);
    }

    public int getCircleBorderColor() {
        return mDelegate.getCircleBorderColor();
    }

    public void setCircleBorderColorRes(int colorRes) {
        mDelegate.setCircleBorderColorRes(colorRes);
    }
}
