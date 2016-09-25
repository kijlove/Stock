package com.sphd.kij.stock.mvp.view;

import com.sphd.kij.stock.base.BaseView;
import com.sphd.kij.stock.info.MyStockMarke;


import java.util.List;

/**
 * 主菜单显示的的mvp中的结构
 * Created by kij on 16/9/13.
 */
public interface MainView extends BaseView {
    void initShowStockList(MyStockMarke myStockMarkeList);
}
