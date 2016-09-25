package com.sphd.kij.stock.mvp.presenter;

import com.sphd.kij.stock.mvp.presenter.base.BasePresenter;

/**
 * Created by kij on 16/9/19.
 */
public interface AllStockPresenter extends BasePresenter {
    void onLoadStockList();

    void refreshData();

    void loadMore();

    void setStockArea(String area);
}
