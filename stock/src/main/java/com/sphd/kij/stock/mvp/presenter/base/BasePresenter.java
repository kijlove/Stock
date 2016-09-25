package com.sphd.kij.stock.mvp.presenter.base;

import android.support.annotation.NonNull;

import com.sphd.kij.stock.base.BaseView;

/**
 * Created by kij on 16/9/13.
 */

public interface BasePresenter {

//    void onResume();

    void onCreate();

    void attachView(@NonNull BaseView view);

    void onDestroy();

}
