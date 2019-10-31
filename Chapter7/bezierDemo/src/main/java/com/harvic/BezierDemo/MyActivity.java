package com.harvic.BezierDemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.bezier_wave).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,BezierWaveActivity.class));
            }
        });

        findViewById(R.id.normal_gesture_track).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,NormalGestureTrackActivity.class));
            }
        });


        findViewById(R.id.bezier_gesture_track).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,BezierGestureTrackActivity.class));
            }
        });

        findViewById(R.id.anim_wave_demo).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,AnimWaveActivity.class));
            }
        });
    }
}
