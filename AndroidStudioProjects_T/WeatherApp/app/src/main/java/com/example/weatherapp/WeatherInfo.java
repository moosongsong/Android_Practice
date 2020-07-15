package com.example.weatherapp;

public class WeatherInfo {
    String countryName;
    String iconName;

    public WeatherInfo(String countryName, int iconNumber) {
        this.countryName = countryName;
        this.iconName = iconNumberToImageName(iconNumber);
    }

    private static String iconNumberToImageName(int iconNumber) {
        if (iconNumber < 1 || iconNumber > 38)
            return "tick_weather_010";  // ? image
        else
            return String.format("tick_weather_%03d", iconNumber);
    }
}
