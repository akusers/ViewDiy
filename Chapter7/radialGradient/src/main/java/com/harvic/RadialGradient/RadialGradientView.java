package com.harvic.RadialGradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by qijian on 17/2/5.
 */
public class RadialGradientView extends View {
    private Paint mPaint;
    private RadialGradient mRadialGradient;
    private int mRadius;

    public RadialGradientView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint();
    }

    @Override
protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    /**
     * 两色渐变
     */
    if (mRadialGradient == null){
        mRadius = getWidth()/6;
        mRadialGradient = new RadialGradient(getWidth()/2,getHeight()/2,mRadius,0xffff0000,0xff00ff00, Shader.TileMode.CLAMP);
        mPaint.setShader(mRadialGradient);
    }

    /**
     * 多色渐变
     */
//        if (mRadialGradient == null) {
//            mRadius = getWidth() / 2;
//            int[] colors = new int[]{0xffff0000, 0xff00ff00, 0xff0000ff, 0xffffff00};
//            float[] stops = new float[]{0f, 0.2f, 0.5f, 1f};
//            mRadialGradient = new RadialGradient(getWidth() / 2, getHeight() / 2, mRadius, colors, stops, Shader.TileMode.REPEAT);
//            mPaint.setShader(mRadialGradient);
//        }


    canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);
}
}
