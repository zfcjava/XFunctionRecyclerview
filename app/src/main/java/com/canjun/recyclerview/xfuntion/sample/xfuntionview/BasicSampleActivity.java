package com.canjun.recyclerview.xfuntion.sample.xfuntionview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.canjun.recyclerview.xfuntion.sample.R;
import com.canjun.recyclerview.xfuntion.xrecyclerview.XRclController;

public class BasicSampleActivity extends AppCompatActivity {

    private RecyclerView rcl_listview;

    private XRclController xRclController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_sample);
        initView();
    }

    private void initView() {
        rcl_listview = findViewById(R.id.rcl_listview);
        xRclController = new XRclController(rcl_listview);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (xRclController != null) {
            xRclController.release();
        }
    }
}
