package com.sphd.kij.stock.activitys.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.socks.library.KLog;
import com.sphd.kij.stock.R;
import com.sphd.kij.stock.base.StockApplication;
import com.sphd.kij.stock.di.component.ActivityComponent;

import com.sphd.kij.stock.di.component.DaggerActivityComponent;
import com.sphd.kij.stock.di.module.ActivityModule;
import com.sphd.kij.stock.mvp.presenter.base.BasePresenter;
import com.sphd.kij.stock.utils.NetUtil;

import butterknife.ButterKnife;

/**
 * Created by kij on 16/9/14.
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    protected ActivityComponent mActivityComponent;
    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    protected T mPresenter;

    public abstract int getLayoutId();

    public abstract void initInjector();

    public abstract void initViews();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        KLog.i(getClass().getSimpleName());
        NetUtil.isNetworkErrThenShowMsg();
        initActivityComponent();
        int layoutId = getLayoutId();
        setContentView(layoutId);
        initInjector();
        ButterKnife.bind(this);
        initToolBar();
        initViews();
        if (mPresenter != null) {
            mPresenter.onCreate();
        }
    }
    private void initActivityComponent() {
        mActivityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((StockApplication) getApplication()).getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void initToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mPresenter != null) {
            mPresenter.onDestroy();
        }

    }

}
