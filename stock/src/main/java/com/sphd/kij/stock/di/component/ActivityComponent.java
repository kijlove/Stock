package com.sphd.kij.stock.di.component;

import android.app.Activity;
import android.content.Context;

import com.sphd.kij.stock.activitys.allstock.AllStockActivity;
import com.sphd.kij.stock.activitys.mystock.MainActivity;
import com.sphd.kij.stock.activitys.stockinfo.StockInfoActivity;
import com.sphd.kij.stock.di.module.ActivityModule;
import com.sphd.kij.stock.di.scope.ContextLife;
import com.sphd.kij.stock.di.scope.PerActivity;

import dagger.Component;

/**
 * Created by kij on 16/9/13.
 *  全部的activity的注入
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();

    void inject(MainActivity mainActivity);

    void inject(AllStockActivity allStockActivity);

    void inject(StockInfoActivity stockInfoActivity);




}
