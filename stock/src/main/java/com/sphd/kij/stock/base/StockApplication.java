package com.sphd.kij.stock.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;

import com.socks.library.KLog;
import com.sphd.kij.stock.BuildConfig;
import com.sphd.kij.stock.di.component.ApplicationComponent;
import com.sphd.kij.stock.di.component.DaggerApplicationComponent;
import com.sphd.kij.stock.di.module.ApplicationModule;

import org.litepal.LitePalApplication;

/**
 * Created by kij on 16/9/13.
 */
public class StockApplication extends LitePalApplication {

    private ApplicationComponent mApplicationComponent;
    private static Context sAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sAppContext = this;
        initActivityLifecycleLogs();
        KLog.init(BuildConfig.LOG_DEBUG, "stock");
        // 官方推荐将获取 DaoMaster 对象的方法放到 Application 层，这样将避免多次创建生成 Session 对象
        initApplicationComponent();
        initStrictMode();
    }

    private void initActivityLifecycleLogs() {
        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                KLog.v("=========", activity + "  onActivityCreated");
            }

            @Override
            public void onActivityStarted(Activity activity) {
                KLog.v("=========", activity + "  onActivityStarted");
            }

            @Override
            public void onActivityResumed(Activity activity) {
                KLog.v("=========", activity + "  onActivityResumed");
            }

            @Override
            public void onActivityPaused(Activity activity) {
                KLog.v("=========", activity + "  onActivityPaused");
            }

            @Override
            public void onActivityStopped(Activity activity) {
                KLog.v("=========", activity + "  onActivityStopped");
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                KLog.v("=========", activity + "  onActivitySaveInstanceState");
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                KLog.v("=========", activity + "  onActivityDestroyed");
            }
        });
    }
    private void initStrictMode() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(
                    new StrictMode.ThreadPolicy.Builder()
                            .detectAll()
//                            .penaltyDialog() // 弹出违规提示对话框
                            .penaltyLog() // 在logcat中打印违规异常信息
                            .build());
            StrictMode.setVmPolicy(
                    new StrictMode.VmPolicy.Builder()
                            .detectAll()
                            .penaltyLog()
                            .build());
        }
    }
    // Fixme
    private void initApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static Context getAppContext() {
        return sAppContext;
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

}
