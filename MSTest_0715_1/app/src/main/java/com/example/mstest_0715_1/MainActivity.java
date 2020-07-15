package com.example.mstest_0715_1;

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
    private final static String TAG = "MainActivity";
    TextView mtextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtextView = findViewById(R.id.textView);
    }

    public void onButtonClick(View view) {
        switch (view.getId()){
            case R.id.snackBarButton:
                LinearLayout layout = findViewById(R.id.linearLayout);

                Snackbar snackbar = Snackbar.make(layout, "hello snack", Snackbar.LENGTH_INDEFINITE);
                snackbar.setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i(TAG, "Snack bar test");
                    }
                });
                snackbar.getView().setBackgroundColor(Color.RED);
                snackbar.show();
                break;
            case R.id.toast_button:
                Toast.makeText(this, "hello world", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dialogTest:
//                1.
//                Dialog dialog = new Dialog(this);
//                TextView textView = new TextView(this);
//                textView.setText("Hello");
//                dialog.setContentView(textView);
//                dialog.show();

//                2.
                Dialog dialog = new Dialog(this);

                // 전개자 XML 파싱 및 전개하기
                LayoutInflater inflater = LayoutInflater.from(this);
                LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.dialog, null);

                ImageView imageView = linearLayout.findViewById(R.id.imageView);
                final TextView textView = linearLayout.findViewById(R.id.dialog_textView);

                imageView.setImageResource(R.mipmap.ic_launcher);
                textView.setText("대화상자를 열었습니다.");

                dialog.setContentView(linearLayout);
                dialog.show();
                break;

            case R.id.alertDialog:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Dialog Test");
                builder.setMessage("hello, world");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("YES", new Dialog.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mtextView.setText("yes");
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mtextView.setText("cancel");
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                break;
        }
    }
}