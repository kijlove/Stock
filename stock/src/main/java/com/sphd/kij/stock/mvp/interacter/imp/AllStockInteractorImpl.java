package com.sphd.kij.stock.mvp.interacter.imp;

import android.util.Log;

import com.sphd.kij.stock.info.MyStockMarke;
import com.sphd.kij.stock.info.Stocklist;
import com.sphd.kij.stock.key.StockKey;
import com.sphd.kij.stock.listener.RequestCallBack;
import com.sphd.kij.stock.mvp.interacter.AllStockInteractor;
import com.sphd.kij.stock.utils.HttpMethods;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import rx.Subscription;

/**
 * 获取全部的股票列表
 * Created by kij on 16/9/19.
 */
public class AllStockInteractorImpl implements AllStockInteractor<Stocklist> {
    @Inject
    public AllStockInteractorImpl() {
    }
    @Override
    public Subscription lodeAllStockList(final RequestCallBack<Stocklist> callback,  Call<Stocklist> call) {


//        Call<Stocklist> call =
//                HttpMethods.getInstance("http://web.juhe.cn:8080/").getStockService().gethkALLStock(map);
        call.enqueue(new Callback<Stocklist>() {
                         @Override
                         public void onResponse(Call<Stocklist> call,
                                                retrofit2.Response<Stocklist> response) {

                             Stocklist stocklist = response.body();

                             callback.success(stocklist);
                         }

                         @Override
                         public void onFailure(Call<Stocklist> call, Throwable t) {

                             try {
                                 callback.onError(call.execute().code()+"");
                             } catch (IOException e) {
                                 e.printStackTrace();
                             }
                         }
                     }
        );

        return null;
    }
}
