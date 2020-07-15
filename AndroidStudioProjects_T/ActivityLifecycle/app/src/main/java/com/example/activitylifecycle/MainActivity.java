package com.example.activitylifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.se.omapi.SEService;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final static String TAG = "MainActivity";

    ArrayList<Point> mPoints = new ArrayList<>();
    MyView mMyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMyView = new MyView(this);
        setContentView(mMyView);
        Log.i(TAG, "onCreate()");
    }

    @Override protected void onStart() { super.onStart(); Log.i(TAG, "onStart()"); }
    @Override protected void onResume() { super.onResume(); Log.i(TAG, "onResume()"); }
    @Override protected void onPause() { super.onPause(); Log.i(TAG, "onPause()"); }
    @Override protected void onStop() { super.onStop(); Log.i(TAG, "onStop()"); }
    @Override protected void onDestroy() { super.onDestroy(); Log.i(TAG, "onDestroy()"); }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.i(TAG, "onSaveInstanceState()");
        outState.putSerializable("mPoints", mPoints);
        super.onSaveInstanceState(outState);    // 부모 메서드를 호출해야 합니다.
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        // 항상 상위 클래스의 구현을 호출하여 기본 구현에서
        // 뷰 계층 구조의 상태를 복원할 수 있도록 합니다.
        super.onRestoreInstanceState(savedInstanceState);
        ArrayList<Point> points =
                (ArrayList<Point>)savedInstanceState.getSerializable("mPoints");
        mPoints = points;
    }

    class Point implements Serializable {
        float x, y;
        boolean needToDraw;
        public Point(float x, float y, boolean needToDraw) {
            this.x = x;
            this.y = y;
            this.needToDraw = needToDraw;
        }
    }

    class MyView extends View {
        Paint mPaint = new Paint();

        public MyView(Context context) {
            super(context);
            mPaint.setColor(Color.RED);
            mPaint.setStrokeWidth(10);
            mPaint.setAntiAlias(true);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            for (int i = 0; i < mPoints.size(); i++) {
                if (mPoints.get(i).needToDraw) {
                    canvas.drawLine(mPoints.get(i-1).x, mPoints.get(i-1).y,
                            mPoints.get(i).x, mPoints.get(i).y, mPaint);
                }
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch(event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mPoints.add(new Point(event.getX(), event.getY(), false));
                    return true;
                case MotionEvent.ACTION_MOVE:
                case MotionEvent.ACTION_UP:
                    mPoints.add(new Point(event.getX(), event.getY(), true));
                    invalidate();
                    return true;
            }
            return super.onTouchEvent(event);
        }
    }

}