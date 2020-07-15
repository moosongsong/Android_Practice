package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    // 데이터 셋을 준비합니다.
    private ArrayList<WeatherInfo> mWeatherInfo = new ArrayList<>();

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.weather_listView);

        mWeatherInfo.add(new WeatherInfo("Korea", 22));
        mWeatherInfo.add(new WeatherInfo("America", 20));
        mWeatherInfo.add(new WeatherInfo("England", 3));
        mWeatherInfo.add(new WeatherInfo("Mexico", 100));
        mWeatherInfo.add(new WeatherInfo("Canada", 1));
        mWeatherInfo.add(new WeatherInfo("China", 33));

        mListView.setAdapter(new WeatherAdapter(this, mWeatherInfo));
    }
}