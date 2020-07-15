package com.example.activitytest2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 다른 컴포넌트에서 데이터를 사용할 수 있도록 키를 공개합니다.
    public final static String EXTRA_NUMBER = "com.example.NUMBER";

    // 액티비티를 구분하기 위한 식별자를 도입합니다.
    public final static int SQUARE_ACTIVITY = 0;

    EditText mNumberEditText;
    TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumberEditText = findViewById(R.id.number_editText);
        mResultTextView = findViewById(R.id.result_textView);
    }

    public void onButtonClick(View view) {
        String strNumber = mNumberEditText.getText().toString();
        if (!strNumber.isEmpty()) {
            int number = Integer.parseInt(strNumber);

            Intent intent = new Intent(this, SquareActivity.class);
            intent.putExtra(EXTRA_NUMBER, number);
            startActivityForResult(intent, SQUARE_ACTIVITY);
        }
    }

    // 아래의 메서드는 종료된 메서드로부터 결과 값을 받았을 때
    // 호출되는 메서드입니다.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == SQUARE_ACTIVITY) {
            if (resultCode == RESULT_OK)  {
                int result = data.getIntExtra(SquareActivity.EXTRA_RESULT, 0);
                mResultTextView.setText(result+"");
            }
            else {    // RESULT_CANCELED
                mResultTextView.setText("취소됨");
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}