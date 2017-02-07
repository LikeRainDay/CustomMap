package com.example.houshuai.textdemo.manager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.houshuai.textdemo.R;

import java.util.List;

/**
 * @author 候帅
 *         Created by 候帅 on 2017/2/7. 14:06
 */

public class MyRecycleView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<Integer> data;

    public MyRecycleView(List<Integer> data) {
        this.data = data;
    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.manager_recycle_activity_item, parent));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {


        public MyViewHolder(View itemView) {
            super(itemView);


        }
    }

}
