package cn.com.farmcode.utility.widgets.cirlescale;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import cn.com.farmcode.utility.widgets.CircleScaleView;

public class FanCircleDelegate extends AbstractDelegate {
    private float mDegreeFrom = 0;
    private float mDegreeTo = 180;

    public FanCircleDelegate(CircleScaleView circleScaleView, Context context, @Nullable AttributeSet attributeSet) {
        super(circleScaleView, context, attributeSet);
    }

    @Override
    public void setScaleMode(@ScaleMode int scaleMode) {
        if (scaleMode != ScaleMode.UNDEFINED) {
            mScaleMode = scaleMode;
        }
    }

    @Override
    public final int getHalfDirection() {
        return HalfDirection.UNDEFINED;
    }

    @Override
    public final void setHalfDirection(int direction) {
        // TODO: 2018/3/24 nothing
    }

    @Override
    public final int getCircleMode() {
        return CircleMode.FAN;
    }

    @Override
    public final void setFanDegree(float from, float to) {
        if (from != to) {
            mDegreeFrom = from;
            mDegreeTo = to;
        }
    }

    @Override
    public final float getFanDegreeFrom() {
        return mDegreeFrom;
    }

    @Override
    public final float getFanDegreeTo() {
        return mDegreeTo;
    }
}
