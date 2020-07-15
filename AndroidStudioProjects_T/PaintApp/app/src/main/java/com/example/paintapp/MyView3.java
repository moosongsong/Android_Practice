package com.example.paintapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyView3 extends View {
    private final static String TAG = "MyView3";

    private float mStartX, mStartY, mStopX, mStopY;
    private Paint mPaint = new Paint();
    private Path mPath = new Path();    // 선의 정보를 저장하는 객체

    private void initialize() {
        mPaint.setStrokeWidth(10.0F);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
    }

    public MyView3(Context context) {
        super(context);
        initialize();
    }

    public MyView3(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // canvas.drawLine(mStartX, mStartY, mStopX, mStopY, mPaint);
        canvas.drawPath(mPath, mPaint);
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
                mPath.moveTo(mStartX, mStartY); // 시작점의 위치로 이동

                mStopX = event.getX();
                mStopY = event.getY();
                mPath.lineTo(mStopX, mStopY);  // 끝점을 설정
                invalidate();

                mStartX = mStopX;
                mStartY = mStopY;
                return true;
        }
        return super.onTouchEvent(event);
    }
}
