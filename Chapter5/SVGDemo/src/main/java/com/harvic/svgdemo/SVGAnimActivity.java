package com.harvic.svgdemo;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by qijian on 17/1/5.
 */
public class SVGAnimActivity extends AppCompatActivity {
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.svg_anim_activity);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = (ImageView) findViewById(R.id.anim_img);
                AnimatedVectorDrawableCompat animatedVectorDrawableCompat = AnimatedVectorDrawableCompat.create(
                        SVGAnimActivity.this, R.drawable.line_animated_vector
                );
                imageView.setImageDrawable(animatedVectorDrawableCompat);
                ((Animatable) imageView.getDrawable()).start();
            }
        });
    }
}
