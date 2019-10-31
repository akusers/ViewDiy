package com.harvic.PathMeasureDemo;

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

        findViewById(R.id.getsegment_demo).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,GetSegmentDEMOActivity.class));
            }
        });

        findViewById(R.id.getpostan_demo).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,GetPosTanActivity.class));
            }
        });

        findViewById(R.id.alipay_demo).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MyActivity.this,AlipayActivity.class));
            }
        });
    }
}
