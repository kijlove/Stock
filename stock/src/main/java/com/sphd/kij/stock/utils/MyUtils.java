package com.sphd.kij.stock.utils;


import rx.Subscription;

/**
 * Created by kij on 16/9/14.
 */
public class MyUtils {
    public static void cancelSubscription(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
