package com.harvic.BezierDemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by qijian on 17/1/13.
 */
public class NormalGestureTrackView extends View {
    private Path mPath = new Path();
    private Paint mPaint;

    public NormalGestureTrackView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
    }


    @Override
public boolean onTouchEvent(MotionEvent event) {
    switch (event.getAction()){
        case MotionEvent.ACTION_DOWN: {
            mPath.moveTo(event.getX(), event.getY());
            return true;
        }
        case MotionEvent.ACTION_MOVE:
            mPath.lineTo(event.getX(), event.getY());
            postInvalidate();
            break;
        default:
            break;
    }
    return super.onTouchEvent(event);
}

    @Override
protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    canvas.drawColor(Color.WHITE);
    canvas.drawPath(mPath,mPaint);
}
}
