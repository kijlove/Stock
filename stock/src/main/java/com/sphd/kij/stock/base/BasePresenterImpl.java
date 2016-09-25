package com.sphd.kij.stock.base;

import android.support.annotation.NonNull;

import com.sphd.kij.stock.listener.RequestCallBack;
import com.sphd.kij.stock.mvp.presenter.base.BasePresenter;
import com.sphd.kij.stock.utils.MyUtils;

import rx.Subscription;


/**
 * Created by kij on 16/9/13.
 */
public class BasePresenterImpl<T extends BaseView, E> implements BasePresenter, RequestCallBack<E> {
    protected T mView;

    protected Subscription mSubscription;

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {
        MyUtils.cancelSubscription(mSubscription);
    }


    @Override
    public void attachView(@NonNull BaseView view) {
        // TODO?
        mView = (T) view;
    }

    @Override
    public void beforeRequest() {
        mView.showProgress();
    }

    @Override
    public void success(E data) {
        mView.hideProgress();
    }

    @Override
    public void onError(String errorMsg) {
        mView.hideProgress();
        mView.showMsg(errorMsg);
    }

}