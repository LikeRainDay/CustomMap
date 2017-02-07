package com.example.houshuai.textdemo.picture.subPicture;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.houshuai.textdemo.R;

/**
 * @author 候帅
 *         Created by 候帅 on 2017/2/7. 11:42
 */

public class circleImage extends ImageView {
    private static final float DEFAULT_CORNER_VALUE = 20f;
    private static final int DEFAULT_SHADOW_VALUE = 5;
    private float corner_value;
    private float shadow_value;
    private int mWidth;
    private int mHeight;
    private Bitmap mSrc;
    private int type;

    public circleImage(Context context) {
        this(context, null);
    }

    public circleImage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @SuppressLint("Recycle")
    public circleImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.circleImage);
        corner_value = a.getFloat(R.styleable.circleImage_conner_type, DEFAULT_CORNER_VALUE);
        shadow_value = a.getInteger(R.styleable.circleImage_shadow_width, DEFAULT_SHADOW_VALUE);
        mSrc = BitmapFactory.decodeResource(getResources(), a.getResourceId(R.styleable.circleImage_src, 0));
        type = a.getInt(R.styleable.circleImage_type, 0);//默认circle
        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        /**
         * 设置宽度
         * */
        int specmode = MeasureSpec.getMode(widthMeasureSpec);
        int specsize = MeasureSpec.getSize(widthMeasureSpec);
        if (specmode == MeasureSpec.EXACTLY) {//match_parent
            mWidth = specsize;
        } else {
            //由图片决定的宽
            int desireByImg = getPaddingLeft() + getPaddingRight() + mSrc.getWidth();
            if (specmode == MeasureSpec.AT_MOST) {//wrap_content
                mWidth = Math.min(desireByImg, specsize);
            } else {
                mWidth = desireByImg;
            }
        }
        /**
         * 设置高度
         * */
        specmode = MeasureSpec.getMode(heightMeasureSpec);
        specsize = MeasureSpec.getSize(heightMeasureSpec);
        if (specmode == MeasureSpec.EXACTLY) {
            mHeight = specsize;
        } else {
            int desire = getPaddingTop() + getPaddingBottom() + mSrc.getHeight();
            if (specmode == MeasureSpec.AT_MOST) {
                mHeight = Math.min(desire, specsize);
            }
            mHeight = desire;
        }
        setMeasuredDimension(mWidth, mHeight);
    }


    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        switch (type) {
            //绘制圆形
            case 0:
                int min = Math.min(mWidth, mHeight);
                /**
                 * 如果长度不一致，按小的值进行压缩
                 * */
                mSrc = Bitmap.createScaledBitmap(mSrc, min, min, false);
                canvas.drawBitmap(createCircieImage(mSrc, min), 0, 0, null);
                break;
            //绘制边缘圆角
            case 1:
                canvas.drawBitmap(createRoundImage(mSrc),0,0,null);
                break;
        }

    }

    private Bitmap createRoundImage(Bitmap mSrc) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap target = Bitmap.createBitmap(mWidth, mHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(target);
        RectF rectF = new RectF(0, 0, mSrc.getWidth(), mSrc.getHeight());
        canvas.drawRoundRect(rectF,corner_value,corner_value,paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(mSrc,0,0,paint);
        return target;
    }

    private Bitmap createCircieImage(Bitmap mSrc, int min) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);

        Bitmap target = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        /**
         * 产生一个同样大小的画布
         * */
        Canvas canvas = new Canvas(target);
        /**
         * 首先绘制圆形
         * */
        canvas.drawCircle(min / 2, min / 2, min / 2, paint);
        /**
         * 使用SRC_IN
         * */
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        /**
         *绘制图片
         * */
        canvas.drawBitmap(mSrc,0,0,paint);
        return target;
    }


}
