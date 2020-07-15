package com.example.paintapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MyView2 extends View {
    private final static String TAG = "MyView2";
    private float mStartX, mStartY, mStopX, mStopY;
    private Paint mPaint = new Paint();

    private void initialize() {
        mPaint.setStrokeWidth(10.0F);
        mPaint.setStyle(Paint.Style.STROKE);
        // mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
    }

    public MyView2(Context context) {
        super(context);
        initialize();
    }

    public MyView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(mStartX, mStartY, mStopX, mStopY, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStartX = event.getX();
                mStartY = event.getY();
                return true;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                mStopX = event.getX();
                mStopY = event.getY();
                invalidate();

                mStartX = mStopX;
                mStartY = mStopY;
                return true;
        }
        return super.onTouchEvent(event);
    }
}
