package com.canjun.recyclerview.xfuntion.xrecyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class XRclController <T>{

    RecyclerView rcl_listview;
    XRclAdapter adapter;
    List<XRclData<T>> dataSource = new ArrayList<>();


    public XRclController(RecyclerView rcl_listview,int itemRes) {
        this.rcl_listview = rcl_listview;
        adapter = new XRclAdapter<T>(itemRes, dataSource){

            @Override
            void convert(XRclViewHolder helper, T item) {

            }
        };
        //TODO A暂时默认Linlearlayout
        this.rcl_listview.setLayoutManager(new LinearLayoutManager(this.rcl_listview.getContext()));
        this.rcl_listview.setAdapter(adapter);
    }

    /**
     * 设置数据集（内部调用了 数据更新（notifyDataSetChanged()）的的方法）
     * @param datas
     */
    public void setData(List<T> datas){
        syncDataSource(datas);
        adapter.notifyDataSetChanged();
    }


    /**
     * 同步新数据
     * @param datas
     */
    private void syncDataSource(List<T> datas) {
        dataSource.clear();
        for (T data : datas) {
            XRclData<T> xRclData = new XRclData<>();
            xRclData.setRealData(data);
            dataSource.add(xRclData);
        }
    }


    /**
     * 释放rcl_listview引用
     */
    public void release() {
        if (rcl_listview != null) {
            rcl_listview = null;
        }
        if (adapter != null) {
            adapter.release();
        }
    }
}
