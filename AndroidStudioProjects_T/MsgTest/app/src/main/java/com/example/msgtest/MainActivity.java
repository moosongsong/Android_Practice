package com.example.msgtest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    final static String TAG = "MainActivity";

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textView);
    }

    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.toast_button:
//        Toast toast = Toast.makeText(this, "hello, world!", Toast.LENGTH_LONG);
//        toast.show();
                Toast.makeText(this, "hello, world!", Toast.LENGTH_LONG).show();
                break;
            case R.id.snackbar_button:
                // Snackbar.make(view, "hello, world!", Snackbar.LENGTH_LONG).show();
                LinearLayout layout = findViewById(R.id.linearLayout);
                // Snackbar.make(layout, "hello, world!", Snackbar.LENGTH_LONG).show();
                Snackbar snackbar = Snackbar.make(layout, "hello, world!",
                        Snackbar.LENGTH_INDEFINITE);
                snackbar.setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i(TAG, "Snackbar Test");
                    }
                });

                View v = snackbar.getView();
                v.setBackgroundColor(Color.RED);

                snackbar.show();
                break;
            case R.id.dialog_button:
//                Dialog dialog = new Dialog(this);
//                TextView tv = new TextView(this);
//                tv.setText("hello, world");
//                dialog.setContentView(tv);
//                dialog.show();
                Dialog dialog = new Dialog(this);

                // XML 파싱 및 전개하기
                LayoutInflater inflater = LayoutInflater.from(this);
                LinearLayout linearLayout =
                        (LinearLayout) inflater.inflate(R.layout.dialog, null);

                ImageView imageView = linearLayout.findViewById(R.id.dialog_imageView);
                TextView textView = linearLayout.findViewById(R.id.dialog_textView);

                imageView.setImageResource(R.mipmap.ic_launcher);
                textView.setText("대화상자를 열었습니다.");

                dialog.setContentView(linearLayout);
                dialog.show();
                break;
            case R.id.alertDialog_button:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("다이얼로그 테스트");
                builder.setMessage("hello, world");
                builder.setIcon(android.R.drawable.ic_dialog_alert);

                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mTextView.setText("'예' 버튼 클릭");
                    }
                });

                builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mTextView.setText("'아니오' 버튼 클릭");
                    }
                });
                builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       mTextView.setText("'취소' 버튼 클릭");
                    }
                });

                AlertDialog dlg = builder.create();
                dlg.show();
        }
    }
}