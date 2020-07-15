package com.example.widgettest3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        RadioButton.OnClickListener listener = new RadioButton.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switch (view.getId()) {
//                    case R.id.maleRadioButton: Log.i(TAG, "남자"); break;
//                    case R.id.femaleRadioButton: Log.i(TAG, "여자"); break;
//                }
//            }
//        };
//
//        RadioButton maleRadioButton = findViewById(R.id.maleRadioButton);
//        RadioButton femaleRadioButton = findViewById(R.id.femaleRadioButton);
//        maleRadioButton.setOnClickListener(listener);
//        femaleRadioButton.setOnClickListener(listener);

        RadioGroup group = findViewById(R.id.radioGroup);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch(id) {
                    case R.id.maleRadioButton: Log.i(TAG, "남자"); break;
                    case R.id.femaleRadioButton: Log.i(TAG, "여자"); break;
                }
            }
        });
    }
}