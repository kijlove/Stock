package com.sphd.kij.stock.mvp.interacter;

import com.sphd.kij.stock.listener.RequestCallBack;

import rx.Subscription;


/**
 * Created by kij on 16/9/13.
 */
public interface MainInteractor<T> {
    Subscription lodeMyStockList(RequestCallBack<T> callback,String stocks);

}
