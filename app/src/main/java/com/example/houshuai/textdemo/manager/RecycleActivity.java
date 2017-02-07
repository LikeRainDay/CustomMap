package com.example.houshuai.textdemo.manager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;

import com.example.houshuai.textdemo.R;
import com.example.houshuai.textdemo.manager.subManager.CenterScrollListener;
import com.example.houshuai.textdemo.manager.subManager.GalleryLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 候帅
 *         Created by 候帅 on 2017/2/7. 11:37
 */

public class RecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_recycle_activity);

        initData();
        RecyclerView mRecycleView = (RecyclerView) findViewById(R.id.show);
        mRecycleView.setLayoutManager(new GalleryLayoutManager(true, this, Dp2px(10)));
        mRecycleView.addOnScrollListener(new CenterScrollListener());
        mRecycleView.setAdapter(new MyRecycleView(data));
        mRecycleView.setItemAnimator(new DefaultItemAnimator());
    }

    private List<Integer> data;
    private void initData() {
        data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(i, 5);
        }
    }

    private int Dp2px(float dp) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
