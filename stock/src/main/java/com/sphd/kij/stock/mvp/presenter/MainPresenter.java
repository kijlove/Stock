package com.sphd.kij.stock.mvp.presenter;

import com.sphd.kij.stock.mvp.presenter.base.BasePresenter;

/**
 * Created by kij on 16/9/13.
 */
public interface MainPresenter extends BasePresenter {
    void refreshData();
    String setStocks();
}
