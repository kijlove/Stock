package com.sphd.kij.stock.di.component;

import android.content.Context;

import com.sphd.kij.stock.di.module.ApplicationModule;
import com.sphd.kij.stock.di.scope.ContextLife;
import com.sphd.kij.stock.di.scope.PerApp;

import dagger.Component;

/**
 * Created by kij on 16/9/13.
 */

@PerApp
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    @ContextLife("Application")
    Context getApplication();

}

