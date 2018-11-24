package com.canjun.recyclerview.xfuntion.xrecyclerview;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.List;

public abstract class XRclAdapter<T> extends BaseQuickAdapter<XRclData<T>,XRclViewHolder> {

    private XRclController.MutilSelectConfig mutilSelectConfig;

    public XRclAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId, data);
    }

    public XRclAdapter(@Nullable List data) {
        super(data);
    }

    public XRclAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(XRclViewHolder helper, XRclData<T> item) {
        if (null != mutilSelectConfig) {
            //isChecked() 方法对于用户是透明的
            mutilSelectConfig.onItemViewSelectStatusChanged(helper.itemView, item.isChecked());
        }
        convert(helper,item.realData);
    }

    abstract void convert(XRclViewHolder helper, T item);

    /**
     * 释放资源
     */
    public void release() {
        if (mutilSelectConfig != null) {
            mutilSelectConfig = null;
        }
    }

    /**
     * 设置是否开启多选, 如果传入非空的值，正名执行多选操作
     * @param mutilSelectConfig
     */
    public void enableMultiSelect(XRclController.MutilSelectConfig mutilSelectConfig) {
        this.mutilSelectConfig = mutilSelectConfig;
    }
}
