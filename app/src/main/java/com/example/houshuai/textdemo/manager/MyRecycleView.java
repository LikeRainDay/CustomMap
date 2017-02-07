package com.example.houshuai.textdemo.manager;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author 候帅
 *         Created by 候帅 on 2017/2/7. 14:06
 */

public class MyRecycleView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {


        public MyViewHolder(View itemView) {
            super(itemView);


        }
    }

}
