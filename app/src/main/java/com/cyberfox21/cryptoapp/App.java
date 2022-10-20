package com.cyberfox21.cryptoapp;

import android.app.Application;

import com.cyberfox21.cryptoapp.di.DaggerApplicationComponent;

/**
 * @author t.shkolnik
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApplicationComponent.create();
    }
}
