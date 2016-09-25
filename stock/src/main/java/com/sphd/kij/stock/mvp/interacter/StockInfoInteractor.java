package com.sphd.kij.stock.mvp.interacter;

import com.sphd.kij.stock.listener.RequestCallBack;

import rx.Subscription;

/**
 * Created by kij on 16/9/20.
 */

public interface StockInfoInteractor<T> {
    Subscription lodeStockInfo(RequestCallBack<T> callback,String code);
}
