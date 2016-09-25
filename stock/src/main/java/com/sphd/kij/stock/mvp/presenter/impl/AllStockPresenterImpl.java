package com.sphd.kij.stock.mvp.presenter.impl;

import android.support.annotation.NonNull;

import com.socks.library.KLog;
import com.sphd.kij.stock.base.BasePresenterImpl;
import com.sphd.kij.stock.base.BaseView;
import com.sphd.kij.stock.info.MyStockMarke;
import com.sphd.kij.stock.info.Stocklist;
import com.sphd.kij.stock.key.StockKey;
import com.sphd.kij.stock.mvp.interacter.AllStockInteractor;
import com.sphd.kij.stock.mvp.interacter.MainInteractor;
import com.sphd.kij.stock.mvp.interacter.imp.AllStockInteractorImpl;
import com.sphd.kij.stock.mvp.interacter.imp.MainInteractorImpl;
import com.sphd.kij.stock.mvp.presenter.AllStockPresenter;
import com.sphd.kij.stock.mvp.presenter.MainPresenter;
import com.sphd.kij.stock.mvp.view.AllStockView;
import com.sphd.kij.stock.mvp.view.MainView;
import com.sphd.kij.stock.utils.HttpMethods;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * Created by kij on 16/9/19.
 */
public class AllStockPresenterImpl extends BasePresenterImpl<AllStockView, Stocklist>
        implements AllStockPresenter {
    private AllStockInteractor<Stocklist> allStockInteractor;
    private Call<Stocklist> call;
    private String area="sh";
    private int page=1;

    @Inject
    public AllStockPresenterImpl(AllStockInteractorImpl allStockInteractor) {
        this.allStockInteractor = allStockInteractor;
    }

    @Override
    public void onLoadStockList() {

    }

    @Override
    public void refreshData() {

    }

    @Override
    public void loadMore() {
        page++;
        KLog.e("page======"+page);
        loadStockList(page);
    }

    @Override
    public void setStockArea(String area) {
        this.area=area;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        page=1;
        loadStockList(page);
    }


    @Override
    public void success(Stocklist data) {
        super.success(data);
        mView.initShowStockList(data);
    }

    private void loadStockList(int page) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("key", StockKey.juhe_key);
        map.put("type", "1");//每夜的条数
        map.put("page", ""+page);
        switch (area){
            case "sh":
                call = HttpMethods.getInstance("http://web.juhe.cn:8080/").getStockService().getshALLStock(map);
                break;
            case "sz":
                call = HttpMethods.getInstance("http://web.juhe.cn:8080/").getStockService().getszALLStock(map);
                break;
            case "hk":
                call = HttpMethods.getInstance("http://web.juhe.cn:8080/").getStockService().gethkALLStock(map);
                break;
            default:
                call = HttpMethods.getInstance("http://web.juhe.cn:8080/").getStockService().getshALLStock(map);
                break;
        }
        mSubscription = allStockInteractor.lodeAllStockList(this, call);
    }

}
