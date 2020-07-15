package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    // 다른 컴포넌트에서 데이터를 읽을 수 있도록 키를 공개합니다.
    public final static String EXTRA_MESSAGE = "com.example.activitytest.mainactivity.MESSAGE";
    EditText mInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInputEditText = findViewById(R.id.input_editText);
    }

    public void onButtonClick(View view) {
//        Intent intent = new Intent(this, SecondActivity.class);
//        startActivity(intent);

        String msg = mInputEditText.getText().toString();
        if (!msg.isEmpty()) {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(EXTRA_MESSAGE, msg);
            startActivity(intent);
        }
    }
}