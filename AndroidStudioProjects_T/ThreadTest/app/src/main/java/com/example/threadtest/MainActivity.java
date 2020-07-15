package com.example.threadtest;

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
    final static int UPDATE_PROGRESSBAR = 0;

    ProgressBar mProgressBar;
    int progressiveValue = 0;
    Button mButton;
    Thread mThread;

    // UI 쓰레드에 핸들러를 연동합니다.
    Handler mHandler = new Handler(Looper.getMainLooper()) {
        // 메시지 큐로 전달된 메시지를 처리하기 위한 핸들러 메서드
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch(msg.what) {
                case UPDATE_PROGRESSBAR:
                    int percent = msg.arg1;
                    mProgressBar.setProgress(percent);
                    mButton.setText(percent + "%");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = findViewById(R.id.download_progressBar);
        mButton = findViewById(R.id.download_button);
    }

    public void onButtonClick(View view) {
//        progressiveValue += 20;
//        mProgressBar.setProgress(progressiveValue);

//       mProgressBar.setProgress(0);
//       for (int i = 0; i <= 100; i++) {
//           try { Thread.sleep(100); } catch (Exception e) { }
//           // 다운로드 코드
//           mButton.setText(i + "%");
//           mProgressBar.setProgress(i);
//       }

        if (mThread != null)    // 다운로드 중이라면...
            return;

        mThread = new Thread(new Runnable() {
            @Override
            public void run() {
                mProgressBar.setProgress(0);
                for (int i = 0; i <= 100; i++) {
                    try { Thread.sleep(100); } catch (Exception e) { }
                    // 다운로드 코드
//                    mButton.setText(i + "%");
//                    mProgressBar.setProgress(i);
                    // UI를 업데이트 하기 위한 메시지를 생성합니다.
                    Message message = Message.obtain();
                    message.what = UPDATE_PROGRESSBAR;
                    message.arg1 = i;
                    mHandler.sendMessage(message);
                }
                mThread = null;
            }
        });
        mThread.start();
    }   // end of onButtonClick()
}