package com.unflow.sample.java;

import android.app.Application;

import com.unflow.androidsdk.UnflowSdk;

public class UnflowSampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize Unflow SDK
        UnflowSdk.Config unflowConfig = new UnflowSdk.Config("<YOUR_API_KEY>", false);
        UnflowSdk unflow = UnflowSdk.Companion.initialize(this, unflowConfig, null);
        // Sync Unflow content
        unflow.sync();
    }
}