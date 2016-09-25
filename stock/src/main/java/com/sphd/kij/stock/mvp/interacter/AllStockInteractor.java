package com.sphd.kij.stock.mvp.interacter;

import com.sphd.kij.stock.info.Stocklist;
import com.sphd.kij.stock.listener.RequestCallBack;

import retrofit2.Call;
import rx.Subscription;

/**
 * Created by kij on 16/9/19.
 */
public interface AllStockInteractor <T> {
    Subscription lodeAllStockList(RequestCallBack<T> callback,  Call<Stocklist> call);
}
