package com.example.httptest2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textView);

        new Thread(new Runnable() {
            @Override
            public void run() {
                URLReader reader = new URLReader("https://www.google.com/");
                final String data = reader.getData();
                if (data != null) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() { mTextView.setText(data); }
                    });
                }
            }
        }).start();
    }

    private static class URLReader {
        String url;
        public URLReader(String url) {
            this.url = url;
        }

        public String getData() {
            BufferedReader br = null;
            StringBuffer buffer = null;
            HttpURLConnection conn = null;

            try {
                conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setRequestMethod("GET");
                conn.connect();

                br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                buffer = new StringBuffer();
                while (true) {
                    String line = br.readLine();
                    if (line == null)
                        break;
                    buffer.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                if (br != null) try { br.close(); } catch (Exception e) {}
                if (conn != null) conn.disconnect();
            }
            return buffer.toString();
        }
    }
}