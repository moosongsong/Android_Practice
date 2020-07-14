package com.example.paintapp_0714_3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyView2 extends View {
    private static final String TAG = "MyView2";
    private float mStartX, mStartY, mStopx, mStopY;


    private Paint paint = new Paint();

    private void initialize(){
        paint.setStrokeWidth(10.0F);
        paint.setStyle(Paint.Style.STROKE);
//        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
    }

    public MyView2(Context context) {
        super(context);
        initialize();
    }

    public MyView2(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        initialize();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(mStartX, mStartY, mStopx, mStopY, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mStartX = event.getX();
                mStartY = event.getY();
                return true;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                mStopx = event.getX();
                mStopY = event.getY();
                invalidate();
                mStartX = mStopx;
                mStartY = mStopY;
                return true;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}
