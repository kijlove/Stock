package com.sphd.kij.stock.mvp.interacter.imp;

import android.util.Log;

import com.socks.library.KLog;
import com.sphd.kij.stock.info.MyStockMarke;
import com.sphd.kij.stock.info.StockInfo;
import com.sphd.kij.stock.info.StockInfoInternet;
import com.sphd.kij.stock.key.StockKey;
import com.sphd.kij.stock.listener.RequestCallBack;
import com.sphd.kij.stock.mvp.interacter.StockInfoInteractor;
import com.sphd.kij.stock.utils.HttpMethods;

import org.litepal.crud.DataSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import rx.Subscription;


/**
 * Created by kij on 16/9/20.
 */

public class StockInfoInteractorImpl implements StockInfoInteractor<StockInfoInternet> {
    @Inject
    public StockInfoInteractorImpl() {
    }

    @Override
    public Subscription lodeStockInfo(final RequestCallBack<StockInfoInternet> callback,String code) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("showapi_appid", StockKey.showapi_appid);
        map.put("showapi_sign", StockKey.showapi_sign);
        map.put("showapi_timestamp", StockKey.getShowapi_timestamp());
        map.put("code", code);
        map.put("need_k_pic", "1");
        map.put("needIndex", "1");
        KLog.e("获取单条股票信息\n"+map.toString());
        Call<StockInfoInternet> call = HttpMethods.getInstance(null).getStockService().getStockInfoInternet(map);
        call.enqueue(new Callback<StockInfoInternet>() {
                         @Override
                         public void onResponse(Call<StockInfoInternet> call,
                                                retrofit2.Response<StockInfoInternet> response) {

                             StockInfoInternet getStockInfoInternet = response.body();
                             Log.e("map===", getStockInfoInternet.getShowapi_res_code() + "单条数据信息");

                             callback.success(getStockInfoInternet);
                         }

                         @Override
                         public void onFailure(Call<StockInfoInternet> call, Throwable t) {
                             Log.e("map===", "错了");

                         }
                     }
        );

        return null;
    }
}
