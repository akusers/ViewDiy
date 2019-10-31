package com.example.nineOldAndroidsDemo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.widget.Toast;
import com.nineoldandroids.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.nineoldandroids.view.ViewHelper;

/**
 * Created by qijian on 16/12/20.
 */
public class ViewHelperActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_helper_activity);

        final TextView tv = (TextView) findViewById(R.id.tv);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ValueAnimator animator = ValueAnimator.ofFloat(0, 200);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Float cur = (Float) valueAnimator.getAnimatedValue();
                        ViewHelper.setTranslationX(tv, cur);
                        ViewHelper.setTranslationY(tv, cur);
                    }
                });
                animator.setDuration(2000);
                animator.start();
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(ViewHelperActivity.this, "点击了tv", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
