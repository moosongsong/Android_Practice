package com.example.widgettest3_0713;

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
//        1.
//        RadioButton.OnClickListener listener = new RadioButton.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                switch (view.getId()){
//                    case R.id.maleRadio:
//                        Log.i(TAG, "male");
//                        break;
//                    case R.id.femaleRadio:
//                        Log.i(TAG, "female");
//                        break;
//                }
//            }
//        };
//        RadioButton maleRadioButton = findViewById(R.id.maleRadio);
//        RadioButton femaleRadioButton = findViewById(R.id.femaleRadio);
//        maleRadioButton.setOnClickListener(listener);
//        femaleRadioButton.setOnClickListener(listener);


//        2.
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id){
                    case R.id.maleRadio:
                        Log.i(TAG, "male");
                        break;
                    case R.id.femaleRadio:
                        Log.i(TAG, "female");
                        break;
                }
            }
        });
    }

}