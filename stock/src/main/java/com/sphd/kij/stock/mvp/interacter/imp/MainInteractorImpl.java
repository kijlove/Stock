package com.sphd.kij.stock.mvp.interacter.imp;

import android.util.Log;

import com.socks.library.KLog;
import com.sphd.kij.stock.R;
import com.sphd.kij.stock.base.StockApplication;
import com.sphd.kij.stock.info.MyStockMarke;

import com.sphd.kij.stock.info.StockInfo;
import com.sphd.kij.stock.key.StockKey;
import com.sphd.kij.stock.listener.RequestCallBack;
import com.sphd.kij.stock.mvp.interacter.MainInteractor;
import com.sphd.kij.stock.utils.HttpMethods;
import com.sphd.kij.stock.utils.MyUtils;


import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;


/**
 * Created by kij on 16/9/13.
 */
public class MainInteractorImpl implements MainInteractor<MyStockMarke> {

    @Inject
    public MainInteractorImpl() {
    }

    @Override
    public Subscription lodeMyStockList(final RequestCallBack<MyStockMarke> callback,String stocks) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("showapi_appid", StockKey.showapi_appid);
        map.put("showapi_sign", StockKey.showapi_sign);
        map.put("needIndex", "0");
        map.put("showapi_timestamp", StockKey.getShowapi_timestamp());
//        map.put("stocks", "sh601006,sh601007,sh601008,sh601009,sz000018,hk00941");
        map.put("stocks", stocks);
        Call<MyStockMarke> call = HttpMethods.getInstance(null).getStockService().getMyStock(map);
        call.enqueue(new Callback<MyStockMarke>() {
                         @Override
                         public void onResponse(Call<MyStockMarke> call,
                                                retrofit2.Response<MyStockMarke> response) {

                             MyStockMarke myStockMarke = response.body();
                             Log.e("map===", myStockMarke.getShowapi_res_code() + "接受回来了");

                             callback.success(myStockMarke);
                         }

                         @Override
                         public void onFailure(Call<MyStockMarke> call, Throwable t) {
                             Log.e("map===", "错了");

                         }
                     }
        );

        return null;
    }
}
