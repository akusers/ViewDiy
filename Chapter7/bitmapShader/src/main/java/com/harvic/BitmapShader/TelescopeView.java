package com.harvic.BitmapShader;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by qijian on 17/2/3.
 */
public class TelescopeView extends View {
    private Paint mPaint;
    private Bitmap mBitmap,mBitmapBG;
    private int mDx = -1, mDy = -1;

    public TelescopeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.scenery);
    }

    @Override
public boolean onTouchEvent(MotionEvent event) {
    switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            mDx = (int) event.getX();
            mDy = (int) event.getY();
            postInvalidate();
            return true;
        case MotionEvent.ACTION_MOVE:
            mDx = (int) event.getX();
            mDy = (int) event.getY();
            break;
        case MotionEvent.ACTION_UP:
        case MotionEvent.ACTION_CANCEL:
            mDx = -1;
            mDy = -1;
            break;
    }
    postInvalidate();
    return super.onTouchEvent(event);
}

    @Override
protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    if (mBitmapBG == null){
        mBitmapBG = Bitmap.createBitmap(getWidth(),getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvasbg = new Canvas(mBitmapBG);
        canvasbg.drawBitmap(mBitmap,null,new Rect(0,0,getWidth(),getHeight()),mPaint);
    }

    if (mDx != -1 && mDy != -1) {
        mPaint.setShader(new BitmapShader(mBitmapBG, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
        canvas.drawCircle(mDx, mDy, 150, mPaint);
    }
}
}
