package com.example.paintapp_0714_3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView3 extends View {
    private static final String TAG = "MyView3";
    private float mStartX;
    private float mStartY;

    private Paint paint = new Paint();
    private Path path = new Path();// 선의 정보를 저장하는 객체

    private void initialize(){
        paint.setStrokeWidth(10.0F);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
    }

    public MyView3(Context context) {
        super(context);
        initialize();
    }

    public MyView3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
        Log.i(TAG, "touched");
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mStartX = event.getX();
                mStartY = event.getY();
                return true;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                path.moveTo(mStartX, mStartY);
                // 시작점의 위치로 이동
                float mStopX = event.getX();
                float mStopY = event.getY();
                path.lineTo(mStopX, mStopY);
                // 끝점 설정
                invalidate();

                mStartX = mStopX;
                mStartY = mStopY;
                return true;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}
