package com.aspsine.swipetoloadlayout.demo.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.SwipeRefreshHeaderLayout;
import com.aspsine.swipetoloadlayout.demo.R;

/**
 * Created by Aspsine on 2015/9/2.
 */
public class ClassicRefreshHeaderView extends SwipeRefreshHeaderLayout {
    private int mHeaderHeight;
    private TextView tvRefresh;
    private ImageView ivArrow;
    private ImageView ivSuccess;
    private ProgressBar progressBar;


    private Drawable arrowUp;
    private Drawable arrowDown;

    public ClassicRefreshHeaderView(Context context) {
        this(context, null);
    }

    public ClassicRefreshHeaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClassicRefreshHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mHeaderHeight = getResources().getDimensionPixelOffset(R.dimen.refresh_header_height_classic);
        arrowUp = getResources().getDrawable(R.mipmap.classic_arrow_up);
        arrowDown = getResources().getDrawable(R.mipmap.classic_arrow_down);
    }

    @Override
    public void onRefresh() {
        Log.d("ClassicRefreshHeader", "onRefresh()");
        ivArrow.setVisibility(GONE);
        progressBar.setVisibility(VISIBLE);
        tvRefresh.setText("REFRESHING");
    }

    @Override
    public void onPrepare() {
        Log.d("ClassicRefreshHeader", "onPrepare()");
        ivSuccess.setVisibility(GONE);
    }

    @Override
    public void onSwipe(int y) {
        Log.d("ClassicRefreshHeader", "onSwipe(" + y + ")");
        ivArrow.setVisibility(VISIBLE);
        progressBar.setVisibility(GONE);
        ivSuccess.setVisibility(GONE);
        if (y > mHeaderHeight) {
            tvRefresh.setText("RELEASE TO REFRESH");
            ivArrow.setBackgroundDrawable(arrowUp);
        } else if (y < mHeaderHeight) {
            ivArrow.setBackgroundDrawable(arrowDown);
            tvRefresh.setText("SWIPE TO REFRESH");
        }

    }

    @Override
    public void complete() {
        Log.d("ClassicRefreshHeader", "complete()");
        ivArrow.setVisibility(GONE);
        progressBar.setVisibility(GONE);
        ivSuccess.setVisibility(VISIBLE);
        tvRefresh.setText("COMPLETE");
    }

    @Override
    public void onReset() {
        Log.d("ClassicRefreshHeader", "onReset()");
        ivSuccess.setVisibility(GONE);
        ivArrow.setVisibility(GONE);
        progressBar.setVisibility(GONE);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tvRefresh = (TextView) findViewById(R.id.tvRefresh);
        ivArrow = (ImageView) findViewById(R.id.ivArrow);
        ivSuccess = (ImageView) findViewById(R.id.ivSuccess);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
    }
}
