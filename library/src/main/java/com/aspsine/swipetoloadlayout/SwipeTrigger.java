package com.aspsine.swipetoloadlayout;

/**
 * Created by Aspsine on 2015/8/17.
 */
public interface SwipeTrigger {
    void onPrepare();

    void onSwipe(int y);

    void complete();

    void onReset();
}
