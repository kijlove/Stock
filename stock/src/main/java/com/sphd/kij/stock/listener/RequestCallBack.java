package com.sphd.kij.stock.listener;

/**
 * Created by kij on 16/9/13.
 */

public interface RequestCallBack<T> {

    void beforeRequest();

    void success(T data);

    void onError(String errorMsg);
}
