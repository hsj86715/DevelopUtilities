package cn.com.farmcode.utility.widgets.cirlescale;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import cn.com.farmcode.utility.widgets.R;

class CompassDelegate implements DelegateImpl {
    private static final String TAG = "CompassDelegate";
    private static final int[] sDirectionStr = {R.string.direction_e, R.string.direction_s,
            R.string.direction_w, R.string.direction_n};
    private int mCenterX;
    private int mCenterY;
    private int mRadius;

    private Paint mPaint;
    private Paint mIndicatorPaint;
    private CircleScaleDelegate mDelegate;

    @Override
    public void setDelegate(CircleScaleDelegate delegate) {
        mDelegate = delegate;
    }

    @Override
    public void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        mIndicatorPaint = new Paint();
        mIndicatorPaint.setAntiAlias(true);
        mIndicatorPaint.setStyle(Paint.Style.STROKE);
        mIndicatorPaint.setStrokeCap(Paint.Cap.ROUND);
        mIndicatorPaint.setColor(mDelegate.getIndicatorColor());
    }

    @Override
    public void onAttachedToWindow() {
//        mDelegate.getCircleScaleView().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mDelegate.setCurrentAngle(mDelegate.getCurrentAngle() + 6);
//                mDelegate.getCircleScaleView().invalidate();
//                mDelegate.getCircleScaleView().postDelayed(this, 1000);
//            }
//        }, 1000);
    }

    @Override
    public void onDetachedFromWindow() {

    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = mDelegate.getCircleScaleView().getMeasuredWidth() - mDelegate.getCircleScaleView().getPaddingStart()
                - mDelegate.getCircleScaleView().getPaddingEnd();
        int height = mDelegate.getCircleScaleView().getMeasuredHeight() - mDelegate.getCircleScaleView().getPaddingBottom()
                - mDelegate.getCircleScaleView().getPaddingTop();
        if (width >= height) {
            mRadius = height / 2;
            mCenterX = width / 2 + mDelegate.getCircleScaleView().getPaddingStart();
            mCenterY = mRadius + mDelegate.getCircleScaleView().getPaddingTop();
        } else {
            mRadius = width / 2;
            mCenterX = mRadius + mDelegate.getCircleScaleView().getPaddingStart();
            mCenterY = height / 2 + mDelegate.getCircleScaleView().getPaddingTop();
        }
    }

    @Override
    public void draw(Canvas canvas) {
        drawDirections(canvas);
        drawIndicator(canvas, mDelegate.getCurrentAngle());
    }

    @Override
    public void onSizeChanged(int w, int h, int oldw, int oldh) {

    }

    private void drawDirections(Canvas canvas) {
        mPaint.setARGB(128, 255, 255, 255);
        canvas.drawCircle(mCenterX, mCenterY, mRadius / 20, mPaint);
        mPaint.setARGB(255, 255, 255, 255);
        mPaint.setStrokeWidth(2);
        canvas.drawLine(mCenterX - mRadius / 10, mCenterY, mCenterX + mRadius / 10, mCenterY, mPaint);
        canvas.drawLine(mCenterX, mCenterY - mRadius / 10, mCenterX, mCenterY + mRadius / 10, mPaint);

        final float startRadius = mRadius * 0.7f;
        final float endRadiusS = mRadius * 0.78f;
        final float endRadiusL = mRadius * 0.8f;
        final float degreeStart = mRadius * 0.9f;
        final float directionStart = mRadius * 0.6f;
        final float textSize = mRadius * 0.08f;
        for (int i = 272; i <= 630; i += 2) {//从270度开始，模拟top center为0度
            double radians = Math.toRadians(i);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            float endRadius;
            if (i % 30 == 0) {
                mPaint.setARGB(255, 255, 255, 255);
                mPaint.setStrokeWidth(mRadius / 100);
                endRadius = endRadiusL;

                String degree = String.valueOf(i - 270);
                Rect bound = new Rect();
                mPaint.setTextSize(textSize);
                mPaint.getTextBounds(degree, 0, degree.length(), bound);
                mPaint.setTextAlign(Paint.Align.CENTER);
                float x = (float) (degreeStart * cos) + mCenterX;
                float y = (float) (degreeStart * sin) + mCenterY + bound.height() / 2;
                canvas.drawText(degree, x, y, mPaint);
                if (i % 90 == 0) {
                    int direction = (i - 270) / 90 - 1;
                    String directionStr = mDelegate.getContext().getResources().getString(sDirectionStr[direction]);
                    mPaint.setTextSize(textSize * 2);
                    mPaint.getTextBounds(directionStr, 0, directionStr.length(), bound);
                    x = (float) (directionStart * cos) + mCenterX;
                    y = (float) (directionStart * sin) + mCenterY + bound.height() / 2;
                    canvas.drawText(directionStr, x, y, mPaint);
                }
            } else {
                mPaint.setARGB(128, 255, 255, 255);
                mPaint.setStrokeWidth(mRadius / 150);
                endRadius = endRadiusS;
            }
            canvas.drawLine((float) (startRadius * cos) + mCenterX,
                    (float) (startRadius * sin) + mCenterY,
                    (float) (endRadius * cos) + mCenterX,
                    (float) (endRadius * sin) + mCenterY, mPaint);
        }
    }

    private void drawIndicator(Canvas canvas, float angle) {
        mIndicatorPaint.setStrokeWidth(mRadius / 40);
        canvas.drawLine(mCenterX, mCenterY,
                (float) (mRadius * 0.8f * Math.cos(Math.toRadians(angle))) + mCenterX,
                (float) (mRadius * 0.8f * Math.sin(Math.toRadians(angle))) + mCenterY,
                mIndicatorPaint);
    }
}
