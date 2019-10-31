package com.harvic.svgdemo;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by qijian on 17/1/6.
 */
public class SearchEditActivity extends AppCompatActivity {
    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.svg_edit_search_activity);
    final ImageView imageView = (ImageView) findViewById(R.id.anim_img);

    //将焦点放在ImageView上
    imageView.setFocusable(true);
    imageView.setFocusableInTouchMode(true);
    imageView.requestFocus();
    imageView.requestFocusFromTouch();
    EditText  editText = (EditText)findViewById(R.id.edit);

    //当EditText获得焦点时开始动画
    editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus){

                AnimatedVectorDrawableCompat animatedVectorDrawableCompat = AnimatedVectorDrawableCompat.create(
                        SearchEditActivity.this, R.drawable.animated_vecotr_search
                );
                imageView.setImageDrawable(animatedVectorDrawableCompat);
                ((Animatable) imageView.getDrawable()).start();
            }
        }
    });
}
}
