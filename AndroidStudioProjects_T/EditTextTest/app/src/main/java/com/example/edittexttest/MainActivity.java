package com.example.edittexttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";
    private EditText mEditText;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.editText);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 내용이 변경되기 전에 호출되는 메서드
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 내용이 변경될 때 호출되는 메서드
                if (charSequence.length() != 0)
                    mButton.setEnabled(true);
                else
                    mButton.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // 내용이 변경된 후 호출되는 메서드
            }
        });

        mButton = findViewById(R.id.button);
        mButton.setEnabled(false);

    }

    public void onButtonClick(View view) {
        String inputString = mEditText.getText().toString();
        if (!inputString.isEmpty()) {
            Log.i(TAG, inputString);
            mEditText.setText(null);    // 에디트텍스트 내용 삭제
        }
    }
}