package com.example.mytodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";

    private ArrayList<String> mTodoDataSet = new ArrayList<>();
    private ArrayAdapter<String> mListAdapter;

    private EditText mTodoEditText;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTodoEditText = findViewById(R.id.todo_editText);
        mTodoEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                // 사용자가 엔터를 눌렀을 때의 처리만 합니다.
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    String todo = mTodoEditText.getText().toString();
                   if (!todo.isEmpty())  {
                        mTodoDataSet.add(0, todo);
                        mListAdapter.notifyDataSetChanged();    // 리스트뷰를 갱신합니다.
                        mTodoEditText.setText(null);
                        return true;
                   }
                }
                return false;
            }
        });

        mListView = findViewById(R.id.todo_listView);
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(
                    AdapterView<?> adapterView, View view, int position, long id) {
                mTodoDataSet.remove(position);
                mListAdapter.notifyDataSetChanged();
                return true;
            }
        });

        mListAdapter = new ArrayAdapter<>(this, R.layout.list_item, mTodoDataSet);
        mListView.setAdapter(mListAdapter);
    }
}