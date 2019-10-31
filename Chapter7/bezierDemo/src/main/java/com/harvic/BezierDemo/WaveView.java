package com.harvic.BezierDemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by qijian on 17/1/13.
 */
public class WaveView extends View {
    public WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    canvas.drawColor(Color.WHITE);

    Paint paint = new Paint();
    paint.setStyle(Paint.Style.STROKE);
    paint.setStrokeWidth(5);
    paint.setColor(Color.BLACK);

    Path path = new Path();
    path.moveTo(100,300);
    path.quadTo(200,200,300,300);
    path.quadTo(400,400,500,300);

    canvas.drawPath(path,paint);
}
}
