package com.sphd.kij.stock.mvp.presenter.impl;

import com.sphd.kij.stock.base.BasePresenterImpl;
import com.sphd.kij.stock.info.MyStockMarke;
import com.sphd.kij.stock.info.StockInfoInternet;
import com.sphd.kij.stock.info.Stocklist;
import com.sphd.kij.stock.mvp.interacter.StockInfoInteractor;
import com.sphd.kij.stock.mvp.interacter.imp.StockInfoInteractorImpl;
import com.sphd.kij.stock.mvp.presenter.StockInfoPresenter;
import com.sphd.kij.stock.mvp.view.AllStockView;
import com.sphd.kij.stock.mvp.view.StockInfoView;

import javax.inject.Inject;

/**
 * Created by kij on 16/9/20.
 */

public class StockInfoPresenterImpl extends BasePresenterImpl<StockInfoView, StockInfoInternet>
        implements StockInfoPresenter {
    private StockInfoInteractor stockInfoInteractor;
    private String code;//股票ID
    @Inject
    public StockInfoPresenterImpl(StockInfoInteractorImpl stockInfoInteractor) {
        this.stockInfoInteractor=stockInfoInteractor;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mSubscription = stockInfoInteractor.lodeStockInfo(this,code);
    }

    @Override
    public void success(StockInfoInternet stockInfoInternet) {
        super.success(stockInfoInternet);
        mView.initShowStockInfo(stockInfoInternet);
    }

    /*设置股票的编码id*/
    @Override
    public void setCode(String code) {
        this.code=code;
    }
}
