package com.canjun.recyclerview.xfuntion.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.canjun.recyclerview.xfuntion.sample.xfuntionview.MutiSelectRclActivity;
import com.canjun.recyclerview.xfuntion.sample.xfuntionview.SingleSelectRclActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_single_select;
    private TextView tv_muti_select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initLister();
    }

    private void initView() {
        tv_single_select = findViewById(R.id.tv_single_select);
        tv_muti_select = findViewById(R.id.tv_muti_select);
    }

    private void initLister() {
        tv_single_select.setOnClickListener(this);
        tv_muti_select.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.tv_muti_select:
                intent.setClass(this, MutiSelectRclActivity.class);
                break;
            case R.id.tv_single_select:
                intent.setClass(this, SingleSelectRclActivity.class);
                break;
        }
        startActivity(intent);
    }
}
