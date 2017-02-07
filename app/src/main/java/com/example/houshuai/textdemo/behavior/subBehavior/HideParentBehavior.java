package com.example.houshuai.textdemo.behavior.subBehavior;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * @author 候帅
 *         Created by 候帅 on 2017/2/7. 16:51
 */

public abstract class HideParentBehavior extends CoordinatorLayout.Behavior<View> {

    protected final int mTouchSlop;
    protected AnimateHelper mAnimateHelper;
    protected boolean isFirstMove = true;
    protected boolean canInit = true;

    public HideParentBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();

    }

    @SuppressLint("InlinedApi")
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return (nestedScrollAxes & View.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        onNestPreScrollInit(child);
        if (Math.abs(dy)>2) {
            if (dy<0) {
//                if (mAnimateHelper.getState()) {
//                }
            }
        }



    }

    protected abstract void onNestPreScrollInit(View child);


}
