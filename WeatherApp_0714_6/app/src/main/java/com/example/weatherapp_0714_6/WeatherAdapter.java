package com.example.weatherapp_0714_6;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

// 커스텀 어댑터 구현 방법 1. Base Adapter 상속
public class WeatherAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<WeatherInfo> mDataSet;
    private LayoutInflater layoutInflater; // XML을 파싱하는 객체
    private Resources resources;// 이미지 읽어오기 위한 객체

    public WeatherAdapter(Context context, ArrayList<WeatherInfo> dataSet){
        this.context = context;
        this.mDataSet = dataSet;
        this.layoutInflater = LayoutInflater.from(context);
        this.resources = context.getResources();
    }

    // 데이터셋의 총 개수를 반환합니다.
    @Override
    public int getCount() {
        return mDataSet.size();
    }

    // 요청된 포지션의 아이템을 반환합니다.
    @Override
    public Object getItem(int position) {
        return mDataSet.get(position);
    }

    // 요청된 포지션의 고유 식별자를 반환합니다.
    @Override
    public long getItemId(int position) {
        return position;
    }

    // 리스트 뷰의 아이템을 출력하기 위한 뷰를 생성하고 반환합니다.
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            view = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView=view.findViewById(R.id.weather_icon_imageView);
            viewHolder.textView = view.findViewById(R.id.country_name_textView);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)view.getTag();
        }
//        ImageView weatherImageView = view.findViewById(R.id.weather_icon_imageView);
//        TextView countryNameTextView = view.findViewById(R.id.country_name_textView);

        WeatherInfo weatherInfo = mDataSet.get(position);

        // 파일명으로 부터 리소스 아이디를 얻어옵니다.
        int resourceId = resources.getIdentifier("@drawable/"+weatherInfo.iconName, "drawable",context.getPackageName());
        Bitmap bitmap = BitmapFactory.decodeResource(resources, resourceId);

        viewHolder.imageView.setImageBitmap(bitmap);
        viewHolder.textView.setText(weatherInfo.countryName);
        return view;
    }

    // 아이템 뷰 내의 객체들에 대하여 레퍼런스를 별도로 지정합니다.
    private static class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
