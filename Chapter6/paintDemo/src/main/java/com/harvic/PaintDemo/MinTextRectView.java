package com.harvic.PaintDemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by qijian on 17/1/11.
 */
public class MinTextRectView extends View {
    public MinTextRectView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String text = "harvic\'s blog";
        int baseLineY = 90;
        int baseLineX = 0 ;

        //设置paint
        Paint paint = new Paint();
        paint.setTextSize(60); //以px为单位
        paint.setTextAlign(Paint.Align.LEFT);

        //画text所占的区域
        Paint.FontMetricsInt fm = paint.getFontMetricsInt();
        int top = baseLineY + fm.top;
        int bottom = baseLineY + fm.bottom;
        int width = (int)paint.measureText(text);
        Rect rect = new Rect(baseLineX,top,baseLineX+width,bottom);

        paint.setColor(0xA0888888);
        canvas.drawRect(rect,paint);

        //画最小矩形
        Rect minRect = new Rect();
        paint.getTextBounds(text,0,text.length(),minRect);
        minRect.top = baseLineY + minRect.top;
        minRect.bottom = baseLineY + minRect.bottom;
        paint.setColor(Color.BLACK);
        canvas.drawRect(minRect,paint);

        //写文字
        paint.setColor(Color.WHITE);
        canvas.drawText(text, baseLineX, baseLineY, paint);
    }
}
