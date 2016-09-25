package com.sphd.kij.stock.mvp.view;


import com.sphd.kij.stock.base.BaseView;
import com.sphd.kij.stock.info.MyStockMarke;
import com.sphd.kij.stock.info.StockInfoInternet;

/**
 * Created by kij on 16/9/20.
 * 用于显示单个股票信息的
 */

public interface StockInfoView extends BaseView {
    void initShowStockInfo(StockInfoInternet stockInfoInternet);
}
