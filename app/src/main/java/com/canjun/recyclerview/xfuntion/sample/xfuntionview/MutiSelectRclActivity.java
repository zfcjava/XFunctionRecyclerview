package com.canjun.recyclerview.xfuntion.sample.xfuntionview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.canjun.recyclerview.xfuntion.sample.R;
import com.canjun.recyclerview.xfuntion.xrecyclerview.XRclAdapterController;
import com.canjun.recyclerview.xfuntion.xrecyclerview.XRclViewHolder;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class MutiSelectRclActivity extends AppCompatActivity {

    private RecyclerView rcl_listview;
    private XRclAdapterController<String,XRclViewHolder> xRclAdapterController;
    private List<String>  names = new ArrayList<>();
    private TextView tv_selected_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_sample);
        initView();
        initData();
        initListener();
    }


    private void initView() {
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
        //开启多选
        xRclAdapterController.enbleMutilSelect(new XRclAdapterController.MutilSelectConfig() {
            @Override
            public void onItemViewSelectStatusChanged(View itemView, boolean isSelected) {
                View view = itemView.findViewById(R.id.iv_check_btn);
                view.setVisibility(View.VISIBLE);
                view.setSelected(isSelected);
            }

            @Override
            public void syncSelectNum(int seletNum, int total) {
                MutiSelectRclActivity.this.syncSelectNum(seletNum, total);
            }
        });

        tv_selected_btn = findViewById(R.id.tv_selected_btn);
    }


    private void initListener() {
        tv_selected_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> selectedData = xRclAdapterController.getSelectedData();
                Toast.makeText(MutiSelectRclActivity.this, selectedData.size() + "", Toast.LENGTH_SHORT).show();
            }
        });
    }



    public void syncSelectNum(int seletNum, int total) {
        tv_selected_btn.setSelected(seletNum > 0);
        tv_selected_btn.setText("确定(" + seletNum + "/" + total + ")");
    }



    private void initData() {
        if (xRclAdapterController != null) {
            //设置假数据
            mockData();
            xRclAdapterController.setData(names);
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
        if (xRclAdapterController != null) {
            xRclAdapterController.release();
        }
    }
}
