package com.example.edittest_0714;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    private final static String TAG = "MainActivity";
    private EditText editText;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        button.setEnabled(false);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 내용이 변경되기 전에 호출되는 메서드
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // 내용이 변경될 때 호출되는 메서드
                if (charSequence.length() == 0){
                    button.setEnabled(false);
                }
                else {
                    button.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // 내용이 변경된 후 호출되는 메서드
            }
        });
    }

    public void onClickButton(View view) {
        if (editText.getText().toString().isEmpty()){
        }else {
            Toast.makeText(this, editText.getText().toString(), Toast.LENGTH_LONG).show();
            editText.setText(null); // editText 내용 삭제
        }
    }
}