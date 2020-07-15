package com.example.threadtest_0715_5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    final static int UPDATE_PROGRESS = 0;
    ProgressBar progressBar;
    Button button;
//    int progressiveValue = 0;
    Thread thread;

    // UI 쓰레드에 핸들어를 연동합니다.
    Handler handler = new Handler(Looper.getMainLooper()){
        //메시지 큐로 전달된 메시지를 처리하기 위한 핸들러 메서드
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case UPDATE_PROGRESS:
                    int percent = msg.arg1;
                    progressBar.setProgress(percent);
                    button.setText(percent+"%");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        button = findViewById(R.id.button);
    }

    public void onButtonClick(View view) {
//        1.
//        progressiveValue +=20;
//        progressBar.setProgress(progressiveValue);

//        2.
//        progressBar.setProgress(0);
//        for (int i=0;i<=100;i++){
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e){
//
//            }
//            button.setText(i+"%");
//            progressBar.setProgress(i);

        if (thread != null){
            return;
        }
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                progressBar.setProgress(0);
                for (int i = 0 ; i <= 100 ; i++){
                    try {
                        Thread.sleep(100);
                    } catch (Exception ignored){ }
                    // 다운로드 코드

                    // UI를 업데이트하기 위한 메시지를 생성합니다.
                    Message message = Message.obtain();// 가급적 메시지 풀에서 꺼내오쟝
//                    button.setText(i+"%");
//                    progressBar.setProgress(i);
                    message.what=UPDATE_PROGRESS;
                    message.arg1=i;
                    handler.sendMessage(message);

                }
                thread=null;
            }
        });
        thread.start();
    }
}