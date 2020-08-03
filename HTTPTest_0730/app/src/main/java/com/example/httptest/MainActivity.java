package com.example.httptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

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
                URLReader reader = new URLReader("http://www.danawa.com/");
                final String data = reader.getData();
                if (data != null && !data.isEmpty()) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                           mTextView.setText(data);
                        }
                    });
                }
            }
        }).start();
    }

    private class URLReader {
        String url;

        public URLReader(String url) {
            this.url = url;
        }

        public String getData() {
            // URLConnection conn = null;
            HttpURLConnection conn = null;
            BufferedReader reader = null;
            StringBuffer buffer = null;

            try {
                // conn = new URL(url).openConnection();
                conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setRequestMethod("GET");
                conn.connect();

                reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

                buffer = new StringBuffer();
                while (true) {
                    String line = reader.readLine();
                    if (line == null)
                        break;
                    buffer.append(line);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                if (reader != null) try { reader.close(); } catch(Exception e) {}
                if (conn != null) try { conn.disconnect(); } catch (Exception e) {}
            }
            return buffer.toString();
        }
    }
}