package com.sphd.kij.stock.mvp.view;

import com.sphd.kij.stock.base.BaseView;
import com.sphd.kij.stock.info.MyStockMarke;
import com.sphd.kij.stock.info.Stocklist;

/**
 *  全部股票列表
 * Created by kij on 16/9/19.
 */
public interface AllStockView  extends BaseView {
    void initShowStockList(Stocklist stocklist);
}
