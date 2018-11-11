package com.canjun.recyclerview.xfuntion.xrecyclerview;

/**
 * recycler中每个item对应的数据
 */
public class XRclData<T> {

    /**
     * 由客户端提供的真实数据
     */
    public T realData;

    private boolean isChecked;

    public void setRealData(T realData) {
        this.realData = realData;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }
}
