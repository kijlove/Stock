package com.sphd.kij.stock.mvp.presenter.impl;

import com.socks.library.KLog;
import com.sphd.kij.stock.base.BasePresenterImpl;

import com.sphd.kij.stock.info.MyStockMarke;
import com.sphd.kij.stock.info.StockInfo;
import com.sphd.kij.stock.mvp.interacter.MainInteractor;
import com.sphd.kij.stock.mvp.interacter.imp.MainInteractorImpl;
import com.sphd.kij.stock.mvp.presenter.MainPresenter;
import com.sphd.kij.stock.mvp.view.MainView;

import org.litepal.crud.DataSupport;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by kij on 16/9/13.
 */
public class MainPresenterImpl extends BasePresenterImpl<MainView, MyStockMarke>
        implements MainPresenter {

    private MainInteractor<MyStockMarke> listMainInteractor;
    private String stocks;

    @Inject
    public MainPresenterImpl(MainInteractorImpl mainInteractor) {
        listMainInteractor = mainInteractor;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        stocks=setStocks();
        if(stocks!=null){
            mSubscription = listMainInteractor.lodeMyStockList(this, stocks );
        }else{
            onError("暂时没有自选股票请添加。");
        }
    }

    @Override
    public void success(MyStockMarke data) {
        super.success(data);
        mView.initShowStockList(data);
    }

    @Override
    public void onError(String errorMsg) {
        super.onError(errorMsg);

    }

    @Override
    public void refreshData() {
        KLog.e("刷新了刷新了");
        stocks=setStocks();
        if(stocks!=null){
            mSubscription = listMainInteractor.lodeMyStockList(this, stocks );
        }else{
            onError("暂时没有自选股票请添加。");
        }
    }

    @Override
    public String setStocks() {
        String stocks = null;
        List<StockInfo> stockInfoList = DataSupport.findAll(StockInfo.class);
        for (int i = 0; i < stockInfoList.size(); i++) {
            stocks = stocks + "," + (stockInfoList.get(i).getSymbol().startsWith("s") ?
                    stockInfoList.get(i).getSymbol() : "hk" + stockInfoList.get(i).getSymbol());
        }
        stocks = stockInfoList.size() > 0 ?
                stocks.substring(1, stocks.length()) : null;
        return stocks;

    }



}
