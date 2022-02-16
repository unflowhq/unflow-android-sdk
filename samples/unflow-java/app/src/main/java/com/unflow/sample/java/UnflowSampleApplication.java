package com.unflow.sample.java;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.unflow.analytics.AnalyticsListener;
import com.unflow.analytics.UnflowEvent;
import com.unflow.androidsdk.UnflowSdk;
import com.unflow.androidsdk.ui.activity.ActivityProvider;

public class UnflowSampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AnalyticsListener analyticsListener = new AnalyticsListener() {
            @Override
            public void onEvent(@NonNull UnflowEvent unflowEvent) {
                Log.d("UNFLOW ANALYTICS", "$event");
            }
        };

        // Initialize Unflow SDK
        UnflowSdk.Config unflowConfig = new UnflowSdk.Config("<YOUR_API_KEY>", false);
        ActivityProvider activityProvider = new LifecycleActivityProvider(this);
        UnflowSdk client = UnflowSdk.Companion.initialize(
                this,
                unflowConfig,
                analyticsListener,
                activityProvider
        );
        // Sync Unflow content
        client.sync();
    }

    class LifecycleActivityProvider implements ActivityProvider, ActivityLifecycleCallbacks {

        private Activity currentActivity;

        public LifecycleActivityProvider(Application application) {
            application.registerActivityLifecycleCallbacks(this);
        }

        @Override
        public Activity getActivity() {
            return currentActivity;
        }

        @Override
        public void onActivityResumed(@NonNull Activity activity) {
            currentActivity = activity;
        }

        @Override
        public void onActivityPaused(@NonNull Activity activity) {
            if (activity == currentActivity) {
                currentActivity = null;
            }
        }

        @Override
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {}

        @Override
        public void onActivityStarted(@NonNull Activity activity) {}

        @Override
        public void onActivityStopped(@NonNull Activity activity) {}

        @Override
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {}

        @Override
        public void onActivityDestroyed(@NonNull Activity activity) {}
    }
}