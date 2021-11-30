package com.cntt.homecooking;

import android.app.Application;

import com.cntt.homecooking.data_local.DataLocalManager;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DataLocalManager.init(getApplicationContext());
    }
}
