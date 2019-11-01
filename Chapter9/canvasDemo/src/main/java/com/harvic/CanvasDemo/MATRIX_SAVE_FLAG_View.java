package com.harvic.CanvasDemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by harvic on 2017/5/23.
 */
public class MATRIX_SAVE_FLAG_View extends View {
    private Paint mPaint;
    public MATRIX_SAVE_FLAG_View(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mPaint = new Paint();

        mPaint.setColor(Color.GRAY);
    }

    @Override
protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

        canvas.save(Canvas.MATRIX_SAVE_FLAG);
        canvas.rotate(40);
        canvas.drawRect(100,0,200,100,mPaint);
        canvas.restore();

        mPaint.setColor(Color.BLACK);
        canvas.drawRect(100,0,200,100,mPaint);

//    canvas.save(Canvas.MATRIX_SAVE_FLAG);
//    canvas.clipRect(100,0,200,100);
//    canvas.drawColor(Color.GRAY);
//    canvas.restore();
//
//    canvas.drawColor(Color.BLACK);
}
}