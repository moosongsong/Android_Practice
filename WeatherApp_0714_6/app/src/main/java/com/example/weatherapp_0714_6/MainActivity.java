package com.example.weatherapp_0714_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ListView listView;

    // 데이터 셋을 준비합니다.
    private ArrayList<WeatherInfo> weatherInfos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.weather_listView);

        weatherInfos.add(new WeatherInfo("Korea",22));
        weatherInfos.add(new WeatherInfo("America",20));
        weatherInfos.add(new WeatherInfo("england",3));
        weatherInfos.add(new WeatherInfo("Mexico",32));
        weatherInfos.add(new WeatherInfo("Canada",1));
        weatherInfos.add(new WeatherInfo("China",100));


        listView.setAdapter(new WeatherAdapter(this, weatherInfos));
    }
}