package com.unflow.sample.compose

import android.app.Application
import com.unflow.androidsdk.UnflowSdk

@Suppress("unused")
class UnflowComposeApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val unflow = UnflowSdk.initialize(
            context = this,
            config = UnflowSdk.Config(
                apiKey = "<YOUR API KEY HERE>",
                enableLogging = false
            )
        )

        unflow.sync()
    }
}
