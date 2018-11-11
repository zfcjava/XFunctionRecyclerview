package com.canjun.recyclerview.xfuntion.xrecyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class XRclController <T>{

    RecyclerView rcl_listview;
    XRclAdapter adapter;
    List<XRclData<T>> dataSource = new ArrayList<>();

    private boolean enbleMutilSelect;


    public XRclController(RecyclerView rcl_listview,int itemRes,int checkRes) {
        this.rcl_listview = rcl_listview;
        adapter = new XRclAdapter<T>(itemRes, dataSource, checkRes){

            @Override
            void convert(XRclViewHolder helper, T item) {

            }
        };
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (enbleMutilSelect) {
                    XRclData<T> itemData = dataSource.get(position);
                    itemData.setChecked(!itemData.isChecked());
                    adapter.notifyDataSetChanged();
                }
            }
        });
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


    public void enbleMutilSelect(){
        this.enbleMutilSelect = true;
        if (adapter != null) {
            adapter.enableMultiSelect(true);
        }
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
