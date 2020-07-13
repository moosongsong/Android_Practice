package com.example.widgettest_0713;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {//implements View.OnClickListener {
    final static String TAG = "MainActivity";

    //외부에서 이콜백 메서드가 호출되어야 하므로 반드시
    //접근 지정자는 public을 사용해야 하며 인자는 view 객체를 전달받도록 정의해야 한다.
    public void onClickButton(View view) {
        Log.i(TAG, "Button is clicked!");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //EDP : event deliver program

        Button clickButton = findViewById(R.id.clickButton);

//        1.
//        MyOnClickListener listener = new MyOnClickListener();
//        clickButton.setOnClickListener(listener);

//        2.
//        clickButton.setOnClickListener(this);

//        3.
//        View.OnClickListener listener = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.i(TAG, "Button is clicked!");
//            }
//        };
//        clickButton.setOnClickListener(listener);

//        4. 익명 임시객체를 사용한 리스너 등록
//        clickButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {//익명 임시 객체
//                Log.i(TAG, "Button is clicked!");
//            }
//        });

//        5. 람다 사용하기
//        clickButton.setOnClickListener(view -> Log.d(TAG, "Button clicked"));
    }

//    2.
//    @Override
//    public void onClick(View view) {
//        Log.i(TAG, "Button is clicked!");
//    }
    // 설계관점에서는 좋지가 않다.
    // 코드를 재사용하려면 해당 코드는 하나의 기능만 하면 좋은데,
    // 객체가 다양한 기능을 제공하게 되면, 재사용성이 떨어진다.
    // 단일 책임의 원칙에 위배되는 행위이다.
}

//1.
//class MyOnClickListener implements View.OnClickListener{
//    @Override
//    public void onClick(View view) {
//        Log.i(MainActivity.TAG, "Button is clicked!");
//    }
//    //이런식의 이벤트 처리는, 매 이벤트 처리마다 클래스를 구현해야 하므로 번거로움이 있다.
//}