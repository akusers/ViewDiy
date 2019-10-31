package com.harvic.ShadowLayerDemo;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by qijian on 17/1/22.
 */
public class BitmapShadowView extends View {
    private Paint mPaint;
    private Bitmap mBitmap, mAlphaBmp;

    public BitmapShadowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat_dog);
        mAlphaBmp = mBitmap.extractAlpha();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = 200;
        int height = width * mAlphaBmp.getWidth() / mAlphaBmp.getHeight();

        //绘制阴影
        mPaint.setColor(Color.GRAY);
        mPaint.setMaskFilter(new BlurMaskFilter(10, BlurMaskFilter.Blur.NORMAL));
        canvas.drawBitmap(mAlphaBmp, null, new Rect(10, 10, width, height), mPaint);

        //绘制原图像
        canvas.translate(-5, -5);
        mPaint.setMaskFilter(null);
        canvas.drawBitmap(mBitmap, null, new Rect(0, 0, width, height), mPaint);
    }


}
