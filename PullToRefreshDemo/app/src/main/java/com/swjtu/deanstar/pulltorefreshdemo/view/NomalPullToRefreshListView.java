package com.swjtu.deanstar.pulltorefreshdemo.view;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

import com.swjtu.deanstar.pulltorefreshdemo.R;

/**
 *
 * 普通的下拉刷新，加载更多listview
 * Created by yhp5210 on 2016/10/13.
 */

public class NomalPullToRefreshListView extends ListView {

    private View mHeaderView;
    private float mOldXPos;
    private float mOldYPos;
    private float mNewXPos;
    private float mNewYPos;
    private int   mHeadHeight;

    public NomalPullToRefreshListView(Context context) {
        super(context);
    }

    public NomalPullToRefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mHeaderView = LayoutInflater.from(context).inflate(R.layout.commonlistview_headerview,null);
    }

    public NomalPullToRefreshListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:{

                mOldXPos = ev.getX();
                mOldYPos = ev.getY();
                Log.d("tag","ev.getX()="+ev.getX() +",ev.getRawX()="+ev.getRawX());
            }break;
            case MotionEvent.ACTION_MOVE:{

                mNewXPos = ev.getX();
                mNewYPos = ev.getY();
                mHeadHeight = mHeaderView.getMeasuredHeight();
                if(mNewYPos > mOldYPos && (mNewYPos - mOldYPos) >= mHeadHeight){
                    Log.d("tag","上滑结束");

                }else if(mNewYPos > mOldYPos && (mNewYPos - mOldYPos) < mHeadHeight){
                    Log.d("tag","上滑进行");
                }


            }break;
            case MotionEvent.ACTION_UP:{


            }break;
        }
        return super.onTouchEvent(ev);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void addFooterView(View v) {
        super.addFooterView(v);
    }

    @Override
    public void addHeaderView(View v) {

        super.addHeaderView(mHeaderView);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

       if(0 == getFirstVisiblePosition() || getLastVisiblePosition() == getChildCount() - 1){
            return true;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
