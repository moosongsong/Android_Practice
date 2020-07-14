package com.example.paintapp_0714_3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

// 커스텀 뷰 만드는 방법 1. View 클래스를 상속합니다.
public class MyView extends View {
    private static final String TAG = "MyView";
    private int[] color = {Color.RED, Color.GRAY, Color.BLUE};
    private int index = 0;

    private Paint paint;
    // 커스텀 뷰 만드는 방법 2. 부모 클래스의 생성자 호출
    public MyView(Context context) {
        super(context); // 반드시 컨텍스트 객체를 전달해야합니다.

        paint = new Paint();
        paint.setColor(Color.RED);
    }

    // XML 상에서 추가하고 싶은 경우, 아래의 생성자를 추가해야합니다.
    // 두번째 인자는 XML 상에서 사용된 속성 정보가 전달됩니다.
    public MyView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);

        paint = new Paint();
        paint.setColor(Color.RED);
    }

    // 커스텀 뷰를 만드는 방법 3. onDraw 메서드를 오버라이딩
    // 화면에 그려지는 객체들은 모두 자신이 어떻게 그려져야 할지를
    // 알고 있습니다. 이에 대한 정보는 onDraw 메서드에 정의되어 있습니다.
    @Override
    protected void onDraw(Canvas canvas) {
        // 이 메서드는 안드로이드에 의해 자동으로 콜백됩니다.
        super.onDraw(canvas);
        // 캔버스에는 다양한 그리기 알고리즘에 제공됩니다.
        paint.setStyle(Paint.Style.FILL); // 도형을 해당 속성으로 채우기(기본값)
        paint.setStrokeWidth(10.0F);
        canvas.drawRect(100, 100, 500, 500, paint);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(500, 500, 400, paint);
        paint.setAntiAlias(true);

        paint.setTextSize(200);
        canvas.drawText("hello world", 20, 600, paint);

        canvas.drawLine(20, 20, 500, 500, paint);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "touched");
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            index = (index + 1) % color.length;
            paint.setColor(color[index]);
            invalidate(); // 뷰를 다시 그리기 위해 onDraw 메서드를 호출해야 하는데
            // 이를 직접 호출하면 안되고 안드로이드가 호출하도록 해야 합니다.
            return true;
        }
        return super.onTouchEvent(event);
    }
}
