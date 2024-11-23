package com.example.sopkathon_android_team3

import android.app.Application
import timber.log.Timber

class SoptApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setTimber()
    }

    private fun setTimber() {
        Timber.plant(Timber.DebugTree())
    }
}