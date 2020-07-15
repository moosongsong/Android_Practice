package com.example.activitytest2_0715_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SquareActivity extends AppCompatActivity {
    public final static String EXTRA_RESULT = "com.example.RESULT";
    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);

        Intent intent = getIntent();
        number = intent.getIntExtra(MainActivity.EXTRA_NUMBER, 0);

        TextView textView = findViewById(R.id.number_TextView);
        textView.setText(number+"");
    }


    public void onButtonClick(View view) {
        switch (view.getId()){
            case R.id.squareButton:
                Intent intent = new Intent();
                intent.putExtra(EXTRA_RESULT, number*number);
                setResult(RESULT_OK, intent);
                finish();//액티비티를 종료하는 함수
                break;
            case R.id.cancelButton:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}