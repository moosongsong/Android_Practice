package com.example.widgettest4_0713;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    final static String TAG = "MainActivity";
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.inputEditText);
    }

    public void onButtonClick(View view) {
        String str = editText.getText().toString();
        if (str.isEmpty() == false){
            Log.i(TAG, str);
        }
    }
}