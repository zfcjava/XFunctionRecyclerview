package com.canjun.recyclerview.xfuntion.sample.xfuntionview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.canjun.recyclerview.xfuntion.sample.R;
import com.canjun.recyclerview.xfuntion.xrecyclerview.XRclAdapterController;
import com.canjun.recyclerview.xfuntion.xrecyclerview.XRclViewHolder;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class BasicSelectRclActivity extends AppCompatActivity {

    protected RecyclerView rcl_listview;
    protected XRclAdapterController<String,XRclViewHolder> xRclAdapterController;
    protected List<String> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initData();
        initListener();
    }

    protected int getLayoutId() {
        return 0;
    }

    protected  void initListener() {
    }


    protected void initView() {
        rcl_listview = findViewById(R.id.rcl_listview);
        xRclAdapterController = new XRclAdapterController<String,XRclViewHolder>(rcl_listview,R.layout.item){

            @Override
            protected void convert(XRclViewHolder helper, String item) {
                helper.setText(R.id.tv_friend_name, item);
            }

            @Override
            protected void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        };
    }




    protected void initData() {
        if (xRclAdapterController != null) {
            //设置假数据
            mockData();
            xRclAdapterController.setData(data);
        }
    }

    /**
     * 模拟一些假数据
     */
    private void mockData() {
        for (int i = 0; i < 20; i++) {
            data.add("zhangsan " + i);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (xRclAdapterController != null) {
            xRclAdapterController.release();
        }
    }
}
