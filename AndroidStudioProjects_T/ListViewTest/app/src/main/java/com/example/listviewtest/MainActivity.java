package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names.add("daniel");
        names.add("susan");
        names.add("andrew");
        names.add("monica");
        names.add("joshep");
        names.add("choi");

        // 어댑터를 생성합니다.
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, R.layout.list_item, names);

        // 어댑터를 리스트 뷰에 연동합니다.
        ListView listView = findViewById(R.id.name_listView);
        listView.setAdapter(adapter);
    }
}