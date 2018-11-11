package com.canjun.recyclerview.xfuntion.xrecyclerview;

import android.support.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.List;

public abstract class XRclAdapter<T> extends BaseQuickAdapter<XRclData<T>,XRclViewHolder> {

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
        //TODO 这里处理单选 ， 多选的业务逻辑

        convert(helper,item.realData);
    }

    abstract void convert(XRclViewHolder helper, T item);

    /**
     * 释放资源
     */
    public void release() {

    }
}
