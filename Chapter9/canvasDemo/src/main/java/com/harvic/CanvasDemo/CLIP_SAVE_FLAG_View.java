package com.harvic.CanvasDemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by harvic on 2017/5/24.
 */
public class CLIP_SAVE_FLAG_View extends View {
    private Paint mPaint;
    public CLIP_SAVE_FLAG_View(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mPaint = new Paint();

    }

    @Override
protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

//        canvas.drawColor(Color.RED);
//        canvas.save(Canvas.CLIP_SAVE_FLAG);
//        canvas.clipRect(100,0,200,100);
//        canvas.restore();
//
//        canvas.drawColor(Color.YELLOW);

    mPaint.setColor(Color.GRAY);
    canvas.drawRect(100,0,200,100,mPaint);

    canvas.save(Canvas.CLIP_SAVE_FLAG);
    canvas.rotate(40);
    canvas.restore();

    mPaint.setColor(Color.BLACK);
    canvas.drawRect(100,0,200,100,mPaint);
}
}
