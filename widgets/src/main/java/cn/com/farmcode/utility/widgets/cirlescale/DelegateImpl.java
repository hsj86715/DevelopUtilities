package cn.com.farmcode.utility.widgets.cirlescale;

import android.graphics.Canvas;


public interface DelegateImpl {
    void setDelegate(CircleScaleDelegate delegate);

    void initPaint();

    void onMeasure(int widthMeasureSpec, int heightMeasureSpec);

    void draw(Canvas canvas);
}
