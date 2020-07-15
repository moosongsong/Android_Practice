package com.example.weatherapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

// 커스텀 어댑터 구현 방법 1. BaseAdapter 상속
public class WeatherAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<WeatherInfo> mDataSet;
    private LayoutInflater mLayoutInflater;   // XML을 파싱하는 객체
    private Resources mResources;       // 이미지를 읽어오기 위한 객체

    public WeatherAdapter(Context context, ArrayList<WeatherInfo> dataSet) {
        this.mContext = context;
        this.mDataSet = dataSet;
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.mResources = mContext.getResources();
    }

    // 데이터셋의 총 개수를 반환합니다.
    @Override
    public int getCount() { return mDataSet.size(); }

    // 요청된 포지션의 아이템을 반환합니다.
    @Override
    public Object getItem(int positon) { return mDataSet.get(positon); }

    // 요청된 포지션의 고유 식별자를 반환합니다.
    @Override
    public long getItemId(int position) { return position; }

    // 리스트뷰의 아이템을 출력하기 위한 뷰를 생성하고 반환합니다.
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.list_item, viewGroup, false);
            holder = new ViewHolder();
            holder.imageView = view.findViewById(R.id.weather_icon_imageView);
            holder.textView = view.findViewById(R.id.country_name_textView);
            view.setTag(holder);    // 뷰에 관련된 데이터를 저장하는 공간
        }
        else {
            holder = (ViewHolder)view.getTag();
        }
        WeatherInfo weatherInfo = mDataSet.get(position);
        int resId = mResources.getIdentifier("@drawable/" + weatherInfo.iconName,
                "drawable", mContext.getPackageName());

        Bitmap bitmap = BitmapFactory.decodeResource(mResources, resId);

        holder.imageView.setImageBitmap(bitmap);
        holder.textView.setText(weatherInfo.countryName);
        return view;
    }

    // 아이템 뷰 내의 객체들에 대하여 레퍼런스를 별도로 저장(캐싱)합니다.
    private static class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
