package com.harvic.ShadowLayerDemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by qijian on 17/1/18.
 */
public class ShadowLayerActivity extends Activity implements View.OnClickListener{
    private ShadowLayerView mShadowLayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shadow_layer_activity);

        mShadowLayerView = (ShadowLayerView)findViewById(R.id.shadowlayerview);
        findViewById(R.id.radius_btn).setOnClickListener(this);
        findViewById(R.id.dx_btn).setOnClickListener(this);
        findViewById(R.id.dy_btn).setOnClickListener(this);
        findViewById(R.id.clear_btn).setOnClickListener(this);
        findViewById(R.id.show_btn).setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.radius_btn:
                mShadowLayerView.changeRadius();
                break;
            case R.id.dx_btn:
                mShadowLayerView.changeDx();;
                break;
            case R.id.dy_btn:
                mShadowLayerView.changeDy();
                break;
            case R.id.clear_btn:
                mShadowLayerView.setShadow(false);
                break;
            case R.id.show_btn:
                mShadowLayerView.setShadow(true);
                break;
        }
    }
}
