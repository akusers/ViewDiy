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
public class CLIP_TO_LAYER_SAVE_FLAG_VIEW extends View {
    private Paint mPaint;

    public CLIP_TO_LAYER_SAVE_FLAG_VIEW(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GRAY);
        canvas.saveLayer(0, 0, 300, 300, mPaint, Canvas.CLIP_SAVE_FLAG | Canvas.CLIP_TO_LAYER_SAVE_FLAG);
        canvas.restore();

        canvas.drawColor(Color.BLACK);
    }
}