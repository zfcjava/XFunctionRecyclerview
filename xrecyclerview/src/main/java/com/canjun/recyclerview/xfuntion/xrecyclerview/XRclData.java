package com.canjun.recyclerview.xfuntion.xrecyclerview;

/**
 * recycler中每个item对应的数据
 */
public class XRclData<T> {

    /**
     * 由客户端提供的真实数据
     */
    public T realData;

    public void setRealData(T realData) {
        this.realData = realData;
    }
}
