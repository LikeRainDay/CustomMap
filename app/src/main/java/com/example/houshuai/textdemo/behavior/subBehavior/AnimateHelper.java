package com.example.houshuai.textdemo.behavior.subBehavior;

/**
 * @author 候帅
 *         Created by 候帅 on 2017/2/7. 16:49
 */

public interface AnimateHelper {
    public static int STATE_SHOW = 1;
    public static int STATE_HIDE = 0;

    void show();

    void hide();

    void setStartY(float y);

    void setMode(int modeBottom);

    int getState();
}
