package com.canjun.recyclerview.xfuntion.sample.xfuntionview;

import android.view.View;
import android.widget.Toast;

import com.canjun.recyclerview.xfuntion.sample.R;
import com.canjun.recyclerview.xfuntion.xrecyclerview.XRclAdapterController;
import com.canjun.recyclerview.xfuntion.xrecyclerview.XRclViewHolder;
import com.chad.library.adapter.base.BaseQuickAdapter;


/**
 * 展示单选数据的RecyclerView
 */
public class SingleSelectRclActivity extends BasicSelectRclActivity {

    protected int getLayoutId() {
        return R.layout.activity_single_select;
    }

    @Override
    protected void initView() {
        super.initView();
        //在子类中 重新复制
        xRclAdapterController = new XRclAdapterController<String,XRclViewHolder>(rcl_listview,R.layout.item){

            @Override
            protected void convert(XRclViewHolder helper, String item) {
                helper.setText(R.id.tv_friend_name, item);
            }

            @Override
            protected void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(SingleSelectRclActivity.this, "第" + position + "个item", Toast.LENGTH_SHORT).show();
            }
        };
    }

}
