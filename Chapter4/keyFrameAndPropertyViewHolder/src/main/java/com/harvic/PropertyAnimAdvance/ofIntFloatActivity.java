package com.harvic.PropertyAnimAdvance;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;

/**
 * Created by qijian on 16/12/15.
 */
public class ofIntFloatActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private TextView mTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ofintfloat_activity);

        mTextView = (TextView)findViewById(R.id.tv);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PropertyValuesHolder rotationHolder = PropertyValuesHolder.ofFloat("Rotation", 60f, -60f, 40f, -40f, -20f, 20f, 10f, -10f, 0f);
                PropertyValuesHolder alphaHolder = PropertyValuesHolder.ofFloat("alpha", 0.1f, 1f, 0.1f, 1f);
                ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(mTextView, rotationHolder, alphaHolder);
                animator.setDuration(3000);
                animator.start();
            }
        });
    }
}
