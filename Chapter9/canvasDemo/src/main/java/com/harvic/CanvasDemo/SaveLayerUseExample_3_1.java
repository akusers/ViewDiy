package com.harvic.CanvasDemo;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by harvic on 2017/5/20.
 */
public class SaveLayerUseExample_3_1 extends View {
    private Paint mPaint;
    private Bitmap mBitmap;

    public SaveLayerUseExample_3_1(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog);
        ;
    }

    @Override
protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    canvas.drawBitmap(mBitmap, 0, 0, mPaint);

    int layerID = canvas.saveLayerAlpha(0, 0, 200, 200, 255, Canvas.ALL_SAVE_FLAG);
    canvas.drawColor(Color.WHITE);
    canvas.restoreToCount(layerID);
}
}