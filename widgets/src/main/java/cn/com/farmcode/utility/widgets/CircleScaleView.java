package cn.com.farmcode.utility.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hushujun on 2018/3/21.
 */

public class CircleScaleView extends View {
    private static final String TAG = "CompassView";
    private static final int[] sDirectionStr = {R.string.direction_e, R.string.direction_s,
            R.string.direction_w, R.string.direction_n};
    private int mCenterX;
    private int mCenterY;
    private int mRadius;

    private Paint mPaint;
    private Paint mIndicatorPaint;

    private float mIndicatorAngle = 0;

    public CircleScaleView(Context context) {
        this(context, null);
    }

    public CircleScaleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CircleScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        mIndicatorPaint = new Paint();
        mIndicatorPaint.setAntiAlias(true);
        mIndicatorPaint.setStyle(Paint.Style.STROKE);
        mIndicatorPaint.setStrokeCap(Paint.Cap.ROUND);
        mIndicatorPaint.setARGB(204, 255, 0, 0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth() - getPaddingStart() - getPaddingEnd();
        int height = getMeasuredHeight() - getPaddingBottom() - getPaddingTop();
        if (width >= height) {
            mRadius = height / 2;
            mCenterX = width / 2 + getPaddingStart();
            mCenterY = mRadius + getPaddingTop();
        } else {
            mRadius = width / 2;
            mCenterX = mRadius + getPaddingStart();
            mCenterY = height / 2 + getPaddingTop();
        }
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
                mIndicatorAngle += 6;
                invalidate();
                postDelayed(this, 1000);
            }
        }, 1000);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawDirections(canvas);
        drawIndicator(canvas, mIndicatorAngle);
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
                    String directionStr = getResources().getString(sDirectionStr[direction]);
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
