package com.canjun.recyclerview.xfuntion.sample.xfuntionview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.canjun.recyclerview.xfuntion.sample.R;
import com.canjun.recyclerview.xfuntion.xrecyclerview.XRclController;

import java.util.ArrayList;
import java.util.List;

public class BasicSampleActivity extends AppCompatActivity {

    private RecyclerView rcl_listview;

    private XRclController<String> xRclController;
    private List<String>  names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_sample);
        initView();
        initData();
    }



    private void initView() {
        rcl_listview = findViewById(R.id.rcl_listview);
        xRclController = new XRclController<>(rcl_listview,R.layout.item);
    }


    private void initData() {
        if (xRclController != null) {
            //设置假数据
            mockData();
            xRclController.setData(names);
        }
    }

    /**
     * 模拟一些假数据
     */
    private void mockData() {
        for (int i = 0; i < 20; i++) {
            names.add("zhangsan " + i);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (xRclController != null) {
            xRclController.release();
        }
    }
}
