package com.sphd.kij.stock.di.module;

import android.content.Context;

import com.sphd.kij.stock.base.StockApplication;
import com.sphd.kij.stock.di.scope.ContextLife;
import com.sphd.kij.stock.di.scope.PerApp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kij on 16/9/13.
 */
@Module
public class ApplicationModule {
    private StockApplication mApplication;

    public ApplicationModule(StockApplication application) {
        mApplication = application;
    }

    @Provides
    @PerApp
    @ContextLife("Application")
    public Context provideApplicationContext() {
        return mApplication.getApplicationContext();
    }

}
