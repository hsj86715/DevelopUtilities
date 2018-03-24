package cn.com.farmcode.utility.widgets.cirlescale;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;

import cn.com.farmcode.utility.widgets.CircleScaleView;

/**
 * @author hushujun
 * @hide
 */
public interface CircleScaleDelegate {

    @CircleMode
    int getCircleMode();

    Context getContext();

    CircleScaleView getCircleScaleView();

    void setScaleMode(@ScaleMode int scaleMode);

    void setHalfDirection(@HalfDirection int direction);

    @HalfDirection int getHalfDirection();

    void setFanDegree(float from, float to);

    float getFanDegreeFrom();

    float getFanDegreeTo();

    void setScaleThinColorRes(@ColorRes int colorRes);

    void setScaleThinColor(@ColorInt int color);

    @ColorInt int getScaleThinColor();

    void setScaleThickColorRes(@ColorRes int colorRes);

    void setScaleThickColor(@ColorInt int color);

    @ColorInt int getScaleThickColor();

    void setScaleTextSize(float textSize);

    float getScaleTextSize();

    void setScaleTextColorRes(@ColorRes int colorRes);

    void setScaleTextColor(@ColorInt int color);

    @ColorInt int getScaleTextColor();

    void setScaleStepsCount(int count);

    int getScaleStepsCount();

    void setIndicatorColorRes(@ColorRes int colorRes);

    void setIndicatorColor(@ColorInt int color);

    @ColorInt int getIndicatorColor();

    void setIndicatorStroke(float indicatorStroke);

    float getIndicatorStroke();

    void showCircleBorder(boolean show);

    boolean isShowCircleBorder();

    void setCircleBorderStroke(float strokeWidth);

    float getCircleBorderStroke();

    void setCircleBorderColorRes(@ColorRes int colorRes);

    void setCircleBorderColor(@ColorInt int color);

    @ColorInt int getCircleBorderColor();

    void setScaleThinStroke(float thinStroke);

    float getScaleThinStroke();

    void setScaleThickStroke(float thickStroke);

    float getScaleThickStroke();

    void setRadarScanColorRes(@ColorRes int colorRes);

    void setRadarScanColor(@ColorInt int color);

    @ColorInt int getRadarScanColor();

    void setCurrentAngle(float angleDegree);

    float getCurrentAngle();

    void onMeasure(int widthMeasureSpec, int heightMeasureSpec);

    void draw(Canvas canvas);
}
