package com.canjun.recyclerview.xfuntion.xrecyclerview;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.List;

public abstract class XRclAdapter<T> extends BaseQuickAdapter<XRclData<T>,XRclViewHolder> {

    private int checkRes;
    private boolean enableMultiSelect;

    public XRclAdapter(int layoutResId, @Nullable List data, int checkRes) {
        super(layoutResId, data);
        this.checkRes = checkRes;
    }

    public XRclAdapter(@Nullable List data) {
        super(data);
    }

    public XRclAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(XRclViewHolder helper, XRclData<T> item) {
        //TODO 这里处理单选 ， 多选的业务逻辑
        if (enableMultiSelect) {
            View view = helper.getView(checkRes);
            if (view == null) {
                throw new RuntimeException("checkRes can not be null ");
            }
            view.setVisibility(View.VISIBLE);
            view.setSelected(item.isChecked());
        }
        convert(helper,item.realData);
    }

    abstract void convert(XRclViewHolder helper, T item);

    /**
     * 释放资源
     */
    public void release() {

    }

    /**
     * 设置是否开启多选
     * @param enableMultiSelect
     */
    public void enableMultiSelect(boolean enableMultiSelect) {
        this.enableMultiSelect = enableMultiSelect;
    }
}
