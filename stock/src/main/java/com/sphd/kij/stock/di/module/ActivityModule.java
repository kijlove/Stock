package com.sphd.kij.stock.di.module;

import android.app.Activity;
import android.content.Context;

import com.sphd.kij.stock.di.scope.ContextLife;
import com.sphd.kij.stock.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kij on 16/9/13.
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @PerActivity
    @ContextLife("Activity")
    public Context ProvideActivityContext() {
        return mActivity;
    }

    @Provides
    @PerActivity
    public Activity ProvideActivity() {
        return mActivity;
    }
}
