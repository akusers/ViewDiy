package com.harvic.XfermodeDemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.harvic.XfermodeDemo.activity.*;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.btn_avoidxfermode).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this, AvoidXfermodeActivity.class));
            }
        });

        findViewById(R.id.btn_porterduffxfermode).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this, PorterDuffXfermodeActivity.class));
            }
        });

        findViewById(R.id.btn_lightbook).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this, LightBookActivity.class));
            }
        });

        findViewById(R.id.btn_twitterview).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this, TwitterActivity.class));
            }
        });

        findViewById(R.id.btn_round_img_view).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this, RoundImageActivity.class));
            }
        });

        findViewById(R.id.btn_inverted_img_view).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this, InvertImageActivity.class));
            }
        });

        findViewById(R.id.btn_eraser_view).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this, EraserImageActivity.class));
            }
        });

        findViewById(R.id.btn_text_wave_view).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this, TextWaveActivity.class));
            }
        });

        findViewById(R.id.btn_irregular_wave_view).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this, IrregularWaveActivity.class));
            }
        });


    }
}
