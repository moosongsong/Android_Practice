package com.example.activitylifecycle_0715_4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final static String TAG = "MainActivity";
    ArrayList<Point> points = new ArrayList<>();
    MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myView = new MyView(this);
        setContentView(myView);
        Log.i(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.i(TAG, "onSaveInstanceState");
        outState.putSerializable("points", points);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // 항상 상위 클래스의 구현을 호출하여 기본구현에서
        // 뷰 계층 구조의 상태를 복원할 수 있도록 합니다.
        ArrayList<Point> points =
                (ArrayList<Point>) savedInstanceState.getSerializable("points");
        this.points = points;
    }

    class MyView extends View{
        Paint paint = new Paint();


        public MyView(Context context) {
            super(context);
            paint.setColor(Color.RED);
            paint.setStrokeWidth(10);
            paint.setAntiAlias(true);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            for (int i=0;i<points.size();i++){
                if (points.get(i).needToDraw){
                    canvas.drawLine(points.get(i-1).x, points.get(i-1).y,
                                    points.get(i).x, points.get(i).y, paint);
                }
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    points.add(new Point(event.getX(), event.getY(), false));
                    return true;
                case MotionEvent.ACTION_MOVE:
                case MotionEvent.ACTION_UP:
                    points.add(new Point(event.getX(), event.getY(), true));
                    invalidate();
                    return true;
            }
            return super.onTouchEvent(event);
        }
    }

    class Point implements Serializable {
        float x,y;
        boolean needToDraw;

        public Point(float x, float y, boolean needToDraw){
            this.x = x;
            this.y = y;
            this.needToDraw=needToDraw;
        }
    }
}