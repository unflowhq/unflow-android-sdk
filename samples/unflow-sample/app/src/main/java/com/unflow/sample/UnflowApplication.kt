package com.unflow.sample

import android.app.Application
import android.util.Log
import com.unflow.analytics.AnalyticsListener
import com.unflow.analytics.domain.model.UnflowEvent
import com.unflow.androidsdk.UnflowSdk

@Suppress("unused")
class UnflowApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val unflowAnalyticsListener = object : AnalyticsListener {
            override fun onEvent(event: UnflowEvent) {
                // Do something with the events. e.g. Send to your existing analytics tool
                Log.d("Unflow-Analytics", "$event")
            }
        }

        val unflow = UnflowSdk.initialize(
            application = this,
            config = UnflowSdk.Config("<YOUR_API_KEY_HERE>"),
            analyticsListener = unflowAnalyticsListener
        )

        // Usually some unique id that you may have for your users
        unflow.setUserId("user_kd5689")

        unflow.sync()
    }
}
