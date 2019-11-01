package com.example.harvic.movewindow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.provider.Settings;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnTouchListener, View.OnClickListener {

    private static final String TAG = "TestActivity";

    private Button mCreateWndBtn, mRmvWndBtn;

    private ImageView mImageView;
    private WindowManager.LayoutParams mLayoutParams;
    private WindowManager mWindowManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Intent myIntent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
            startActivityForResult(myIntent, 100);
        } else {
            initView();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100) {
            initView();
        }
    }

    private void initView() {
        mCreateWndBtn = (Button) findViewById(R.id.add_btn);
        mRmvWndBtn = (Button) findViewById(R.id.rmv_btn);
        mCreateWndBtn.setOnClickListener(this);
        mRmvWndBtn.setOnClickListener(this);

        mWindowManager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE: {
                mLayoutParams.x = rawX;
                mLayoutParams.y = rawY;
                mWindowManager.updateViewLayout(mImageView, mLayoutParams);
                break;
            }
            default:
                break;
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        try {
            mWindowManager.removeView(mImageView);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add_btn) {
            mImageView = new ImageView(this);
            mImageView.setBackgroundResource(R.mipmap.ic_launcher);

            mLayoutParams = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, 2099,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                            | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                            | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                    ,
                    PixelFormat.TRANSPARENT);
            mLayoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
            mLayoutParams.gravity = Gravity.TOP | Gravity.LEFT;
            mLayoutParams.x = 0;
            mLayoutParams.y = 300;
            mImageView.setOnTouchListener(this);
            mWindowManager.addView(mImageView, mLayoutParams);
        } else if (v.getId() == R.id.rmv_btn) {
            mWindowManager.removeViewImmediate(mImageView);
        }


    }
}
