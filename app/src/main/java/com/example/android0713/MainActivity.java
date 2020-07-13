package com.example.android0713;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 앱에서 로그를 출력하려면 자바 표준 출력 객체를 사용할 수 있습니다.
        // 단, 오래된 시스템에서는 동작하지 않습니다.
        // System.out.println("hello world:MainActivity-onCreate()");

        // Log.d("MainActivity", "onCreate()");

        // auto import
        // File -> setting

        Log.i(TAG, "onCreate"); // 정보, TAG 명은 보통 클래스 이름을 사용합니다.
        Log.d(TAG, "onCreate"); // 디버그
        Log.v(TAG, "onCreate"); // Verbose(가장 낮은 우선순위)
        Log.w(TAG, "onCreate"); // 경고
        Log.e(TAG, "onCreate"); // 에러
    }
}