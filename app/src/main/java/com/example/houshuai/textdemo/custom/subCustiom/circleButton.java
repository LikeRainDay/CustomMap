package com.example.houshuai.textdemo.custom.subCustiom;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * @author 候帅
 *         Created by 候帅 on 2017/2/7. 13:58
 */

public class circleButton extends Button {

    public circleButton(Context context) {
        this(context, null);
    }

    public circleButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public circleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }



}
