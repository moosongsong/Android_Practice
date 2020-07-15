package com.example.loopertest_0715_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText mNumberEditText;
    TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumberEditText = findViewById(R.id.number_editText);
        mResultTextView = findViewById(R.id.result_TextView);
    }

    public void onButtonClick(View view) {
        
    }
}