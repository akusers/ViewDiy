package com.harvic.PropertyAnimAdvance;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by qijian on 16/12/15.
 */
public class MyTextView extends TextView {
    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public void setCharText(Character character){
        setText(String.valueOf(character));
    }
}