package com.harvic.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by qijian on 16/11/4.
 */

public class CircleOperationActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circle_operation_activity);
        final CanvasOprationView cov = (CanvasOprationView) findViewById(R.id.cov);
        cov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cov.changeState();
            }
        });

    }


}
