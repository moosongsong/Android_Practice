package com.example.widgettest2_0713;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    final static String TAG = "MainActivity";
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.checkbox);
    }

    public void onButtonClick(View view) {
        if (checkBox.isChecked()){
            Log.i(TAG, "checked " + checkBox.getText());
        }else{
            Log.i(TAG, "unchecked "+checkBox.getText());
        }
    }
}