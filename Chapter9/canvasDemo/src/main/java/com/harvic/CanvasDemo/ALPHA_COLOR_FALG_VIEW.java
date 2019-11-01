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
public class ALPHA_COLOR_FALG_VIEW extends View {
    private Paint mPaint;
    public ALPHA_COLOR_FALG_VIEW(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawColor(Color.GRAY);
//
//        canvas.saveLayer(0,0,300,300,mPaint,Canvas.HAS_ALPHA_LAYER_SAVE_FLAG);
//        mPaint.setColor(Color.BLACK);
//        canvas.drawRect(100,100,200,200,mPaint);
//        canvas.restore();


        canvas.drawColor(Color.GRAY);

        canvas.saveLayer(0,0,300,300,mPaint,Canvas.MATRIX_SAVE_FLAG);
        canvas.rotate(40);
        mPaint.setColor(Color.BLACK);
        canvas.drawRect(100, 100, 200, 200, mPaint);
        canvas.restore();
    }
}
