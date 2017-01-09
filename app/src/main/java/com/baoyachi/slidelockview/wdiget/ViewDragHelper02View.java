package com.baoyachi.slidelockview.wdiget;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.baoyachi.slidelockview.R;

/**
 * create time: 2017/1/9
 * author: liaoym
 * description:
 */

public class ViewDragHelper02View extends RelativeLayout {

    private View mView;
    private ViewDragHelper mViewDragHelper;


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mView = findViewById(R.id.img01);
    }


    public ViewDragHelper02View(Context context) {
        this(context, null);
    }

    public ViewDragHelper02View(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewDragHelper02View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mViewDragHelper = ViewDragHelper.create(this, 1f, new ViewDragCallBack());
    }

    class ViewDragCallBack extends ViewDragHelper.Callback {
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return mView.getId() == child.getId();
        }


        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            if (left < getPaddingLeft())
            {
                return getPaddingLeft();
            }
            if (left > getWidth() - child.getMeasuredWidth())
            {
                return getWidth() - child.getMeasuredWidth();
            }
            return left;
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            if (top < getPaddingTop())
            {
                return getPaddingTop();
            }

            if (top > getHeight() - child.getMeasuredHeight())
            {
                return getHeight() - child.getMeasuredHeight();
            }
            return top;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction())
        {
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mViewDragHelper.cancel();
                break;
        }
        return mViewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mViewDragHelper.processTouchEvent(event);
        return true;
    }
}

