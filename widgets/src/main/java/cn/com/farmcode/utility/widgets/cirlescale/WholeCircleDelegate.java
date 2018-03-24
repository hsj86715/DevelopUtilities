package cn.com.farmcode.utility.widgets.cirlescale;

import android.content.Context;
import android.util.AttributeSet;

import cn.com.farmcode.utility.widgets.CircleScaleView;

/**
 * @author hushujun
 * @hide
 */
public class WholeCircleDelegate extends AbstractDelegate {

    public WholeCircleDelegate(CircleScaleView circleScaleView, Context context, AttributeSet attributeSet) {
        super(circleScaleView, context, attributeSet);
    }

    @Override
    public final void setHalfDirection(int direction) {
        // TODO: 2018/3/24 nothing
    }

    @Override
    public final int getHalfDirection() {
        return HalfDirection.UNDEFINED;
    }

    @Override
    public void setScaleMode(@ScaleMode int scaleMode) {
        if (scaleMode != ScaleMode.UNDEFINED) {
            mScaleMode = scaleMode;
            if (mScaleMode == ScaleMode.COMPASS) {
                setDelegateImpl(new CompassDelegate());
            }
        }
    }

    @Override
    @CircleMode
    public final int getCircleMode() {
        return CircleMode.WHOLE;
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
