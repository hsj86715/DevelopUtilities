package cn.com.farmcode.utility.widgets.cirlescale;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import cn.com.farmcode.utility.widgets.CircleScaleView;

public class HalfCircleDelegate extends AbstractDelegate {
    private int mHalfDirection = HalfDirection.UNDEFINED;

    public HalfCircleDelegate(CircleScaleView circleScaleView, Context context, @Nullable AttributeSet attributeSet) {
        super(circleScaleView, context, attributeSet);
    }

    @Override
    public final void setHalfDirection(int direction) {
        if (direction != HalfDirection.UNDEFINED) {
            mHalfDirection = direction;
        }
    }

    @Override
    public int getHalfDirection() {
        return mHalfDirection;
    }

    @Override
    public void setScaleMode(@ScaleMode int scaleMode) {
        if (scaleMode != ScaleMode.UNDEFINED) {
            mScaleMode = scaleMode;
        }
    }

    @Override
    public final int getCircleMode() {
        return CircleMode.HALF;
    }

    @Override
    public final void setFanDegree(float from, float to) {
        // TODO: 2018/3/24 nothing
    }

    @Override
    public final float getFanDegreeFrom() {
        return 0;
    }

    @Override
    public final float getFanDegreeTo() {
        return 0;
    }
}
