package com.myloyal.test

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.myloyal.test.data.Api
import com.myloyal.test.data.ApiModule

class App : Application() {

    companion object {
        lateinit var instance: App
        lateinit var api: Api
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        api = ApiModule.provideApi()

    }
}