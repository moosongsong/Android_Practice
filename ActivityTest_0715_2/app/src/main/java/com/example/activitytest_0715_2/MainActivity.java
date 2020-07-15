package com.example.activitytest_0715_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    //다른 컴포넌트에서 데이터를 읽을 수 있도록 키를 공개
    public final static String EXTRA_MESSAGE="com.example.activitytest.main.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.input_editText);
    }

    public void onButtonClick(View view) {
//        Intent intent = new Intent(this, SecondActivity.class);
//        startActivity(intent);

        String msg = editText.getText().toString();
        if (!msg.isEmpty()){
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(EXTRA_MESSAGE,msg);
            startActivity(intent);
        }
    }
}