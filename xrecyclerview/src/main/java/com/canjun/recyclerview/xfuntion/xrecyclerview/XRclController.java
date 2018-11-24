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

    private MutilSelectConfig mutilSelectConfig;


    public XRclController(RecyclerView rcl_listview,int itemRes) {
        this.rcl_listview = rcl_listview;
        adapter = new XRclAdapter<T>(itemRes, dataSource){
            @Override
            void convert(XRclViewHolder helper, T item) {

            }
        };
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (null != mutilSelectConfig) {
                    XRclData<T> itemData = dataSource.get(position);
                    itemData.setChecked(!itemData.isChecked());
                    adapter.notifyDataSetChanged();
                    //统计选中的数据的数据
                    int selectCount = getCheckedItemCount();
                    int totalCount = dataSource.size();
                    mutilSelectConfig.syncSelectNum(selectCount, totalCount);
                } else {

                }
            }
        });
        this.rcl_listview.setLayoutManager(new LinearLayoutManager(this.rcl_listview.getContext()));
        this.rcl_listview.setAdapter(adapter);
    }


    private int getCheckedItemCount() {
        int selectCount = 0;
        for (XRclData<T> data : dataSource
                ) {
            if (data.isChecked()) {
                selectCount++;
            }
        }
        return selectCount;
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
     * 开启多选模式
     * @param mutilSelectConfig
     */
    public void enbleMutilSelect(MutilSelectConfig mutilSelectConfig){
        this.mutilSelectConfig = mutilSelectConfig;
        if (adapter != null) {
            adapter.enableMultiSelect(mutilSelectConfig);
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

        if (mutilSelectConfig != null) {
            mutilSelectConfig = null;
        }
    }


    public interface MutilSelectConfig{
        /**
         * 当前本选中的View
         *
         * @param itemView 当前的Item中的View
         * @param isSelected 当前的ItemView是否被选中
         */
        void onItemViewSelectStatusChanged(View itemView, boolean isSelected);

        /**
         * 统计当前选中的 item的数目
         * @param seletNum
         * @param total
         */
        void syncSelectNum(int seletNum, int total);

    }
}
