package com.canjun.recyclerview.xfuntion.xrecyclerview;

import android.support.v7.widget.RecyclerView;

public class XRclController {

    RecyclerView rcl_listview;

    public XRclController(RecyclerView rcl_listview) {
        this.rcl_listview = rcl_listview;
    }

    /**
     * 释放rcl_listview引用
     */
    public void release() {
        if (rcl_listview != null) {
            rcl_listview = null;
        }
    }
}
