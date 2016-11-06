package com.swjtu.deanstar.pulltorefreshdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/**
 * Created by yhp5210 on 2016/10/13.
 * 仿淘宝下拉刷新listView
 */

public class LikeTbListView extends ListView {


    public LikeTbListView(Context context) {
        super(context);
    }

    public LikeTbListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LikeTbListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void addHeaderView(View v) {
        super.addHeaderView(v);
    }

    @Override
    public void addFooterView(View v) {
        super.addFooterView(v);
    }


}
