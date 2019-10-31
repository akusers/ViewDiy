package com.harvic.LinearGradient;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by qijian on 17/2/4.
 */
public class LinearGradientView extends View {
    private Paint mPaint;

    public LinearGradientView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         * 双色渐变
         */
//        mPaint.setShader(new LinearGradient(0,getHeight()/2,getWidth(),getHeight()/2,0xffff0000,0xff00ff00, Shader.TileMode.CLAMP));
//        canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);

        /**
         * 多色渐变
         */
        int[] colors = {0xffff0000,0xff00ff00,0xff0000ff,0xffffff00,0xff00ffff};
        float[]  pos = {0f,0.2f,0.4f,0.6f,1.0f};
        LinearGradient multiGradient = new LinearGradient(0,getHeight()/2,getWidth(),getHeight()/2,colors,pos, Shader.TileMode.CLAMP);
        mPaint.setShader(multiGradient);
        canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);

        /**
         * 多色渐变文字
         */
//        int[] colors = {0xffff0000, 0xff00ff00, 0xff0000ff, 0xffffff00, 0xff00ffff};
//        float[] pos = {0f, 0.2f, 0.4f, 0.6f, 1.0f};
//        LinearGradient multiGradient = new LinearGradient(0, 0, getWidth()/2, getHeight()/2, colors, pos, Shader.TileMode.MIRROR);
//        mPaint.setShader(multiGradient);
//        mPaint.setTextSize(50);
//        canvas.drawText("欢迎关注启舰的blog", 0, getHeight()/2, mPaint);

    }
}
