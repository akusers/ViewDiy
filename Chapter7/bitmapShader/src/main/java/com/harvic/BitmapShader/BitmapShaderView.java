package com.harvic.BitmapShader;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by qijian on 17/1/23.
 */
public class BitmapShaderView extends View {
    private Paint mPaint;
    private Bitmap mBmp;
    public BitmapShaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mBmp = BitmapFactory.decodeResource(getResources(), R.drawable.dog_edge);
        mPaint.setShader(new BitmapShader(mBmp, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
    }

    @Override
protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    canvas.drawColor(Color.WHITE);
    //getWidth()用于获取控件宽度，getHeight()用于获取控件高度
    float left = getWidth()/3;
    float top = getHeight()/3;
    float right = getWidth() *2/3;
    float bottom = getHeight() *2/3;

    canvas.drawRect(left,top,right,bottom,mPaint);
//        canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);
}
}
