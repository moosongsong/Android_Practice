package com.example.paintapp_0714_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        // 커스텀 뷰를 생성한고 화면에 붙입니다.
        MyView3 myView = new MyView3(this);
        setContentView(myView);
    }


}