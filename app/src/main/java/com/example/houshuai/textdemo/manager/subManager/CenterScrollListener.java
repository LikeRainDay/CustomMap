package com.example.houshuai.textdemo.manager.subManager;

import android.support.v7.widget.RecyclerView;

/**
 * @author 候帅
 *         Created by 候帅 on 2017/2/7. 15:48
 */

public class CenterScrollListener extends RecyclerView.OnScrollListener {
    private boolean mAutoSet = false;

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        final RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof CustomLayoutManager)) {
            mAutoSet = true;
            return;
        }
        if (!mAutoSet) {
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                final int dx;
                dx = ((CustomLayoutManager) layoutManager).getOffsetCenterView();
                recyclerView.smoothScrollBy(dx, 0);
            }
            mAutoSet = true;
        }
        if (newState==RecyclerView.SCROLL_STATE_DRAGGING||newState==RecyclerView.SCROLL_STATE_SETTLING) {
            mAutoSet = false;
        }
    }

}
