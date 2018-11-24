package com.canjun.recyclerview.xfuntion.sample.xfuntionview;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.canjun.recyclerview.xfuntion.sample.R;
import com.canjun.recyclerview.xfuntion.xrecyclerview.XRclAdapterController;
import java.util.List;


/**
 * 展示多选数据的RecyclerView
 */
public class MutiSelectRclActivity extends BasicSelectRclActivity {

    private TextView tv_selected_btn;

    protected int getLayoutId() {
        return R.layout.activity_basic_sample;
    }

    @Override
    protected void initView() {
        super.initView();
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


    protected void initListener() {
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


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (xRclAdapterController != null) {
            xRclAdapterController.release();
        }
    }
}
