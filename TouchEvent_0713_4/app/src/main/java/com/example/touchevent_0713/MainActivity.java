package com.example.touchevent_0713;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);

        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
//                Log.d(TAG, "Textview is touched");
//                return true;//touch event 가 할 일이 여기서 끝났다면 부모에게 해결을 넘기는 것은 옳지 않기에 true로 지정해야 한다.
                // event chaining

                //사용자가 어떤 액션을 수행했는지를 추출합니다.
                int action = motionEvent.getAction();
                switch (action){
                    case MotionEvent.ACTION_DOWN:
                        //뷰를 눌렀을 때
                        Log.i(TAG, "DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        //뷰를 누른 상태로 이동했을때
                        Log.i(TAG, "MOVE");
                        break;
                    case MotionEvent.ACTION_UP:
                        //뷰로부터 떨어졌을때
                        Log.i(TAG, "UP");
                        break;
                }
                return true;
            }
        });
    }
}