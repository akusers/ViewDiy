package com.harvic.XfermodeDemo.view;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import com.harvic.XfermodeDemo.R;

/**
 * Created by qijian on 17/2/7.
 */
public class AvoidXfermodeView extends View {
    private Paint mPaint;
    private Bitmap mBmp;

    public AvoidXfermodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mBmp = BitmapFactory.decodeResource(getResources(), R.drawable.dog);
    }

    @Override
protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    int width = getWidth() / 2;
    int height = width * mBmp.getHeight() / mBmp.getWidth();

    canvas.save();

    canvas.drawBitmap(mBmp, null, new Rect(0, 0, width, height), mPaint);
    mPaint.setXfermode(new AvoidXfermode(Color.WHITE, 100, AvoidXfermode.Mode.AVOID));

        canvas.drawRect(0,0,width,height,mPaint);

//        canvas.drawRect(0, 0, width, height, mPaint);
//    canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.flower), null, new Rect(0, 0, width, height), mPaint);

    canvas.restore();
}
}
